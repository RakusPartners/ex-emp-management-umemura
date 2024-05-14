package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Administrator;
import com.example.form.InsertAdministratorForm;
import com.example.form.LoginForm;
import com.example.service.AdministratorService;

import jakarta.servlet.http.HttpSession;

/**
 * 管理者登録画⾯を表⽰する処理を記述するcontrollerクラス
 * @author umemura
 */
@Controller
@RequestMapping("/")
public class AdministratorController {

    @Autowired
    private HttpSession session;

    @Autowired
    private AdministratorService administratorService;

    /**
     * administrator/insert.htmlにフォワードします
     * @param form　InsertAdministratorFormオブジェクト
     * @return administrator/insert.html
     */
    @GetMapping("/toInsert")
    public String toInsert(InsertAdministratorForm form) {
        return "administrator/insert";
    }
    /**
     * 管理者情報を登録します
     * @param form　InsertAdministratorFormオブジェクト
     * @return　/(ログイン画⾯)にリダイレクト
     */
    @PostMapping("/insert")
    public String insert(InsertAdministratorForm form) {
        Administrator administrator = new Administrator();
        administrator.setName(form.getName());
        administrator.setMailAddress(form.getMailAddress());
        administrator.setPassword(form.getPassword());
        administratorService.insert(administrator);
        return "redirect:/";
    }
    /**
     * administrator/login.htmlにフォワードする処理を記述します
     * @param form　InsertAdministratorFormオブジェクト
     * @return　administrator/login.htmlにフォワード
     */
    @GetMapping("/")
    public String toLogin(LoginForm form) {
        return "administrator/login";
    }
    @PostMapping("/login")
    public String login(LoginForm form, Model model) {
        Administrator administrator = administratorService.login(form.getMailAddress(), form.getPassword());

        if(administrator == null) {
            model.addAttribute("errorMessage", "メールアドレスまたはパスワードが不正です。");
            return "administrator/login";
        } else {
            session.setAttribute("administratorName", administrator.getName());
            return "redirect:/employee/showList"; 
        }
    }
}

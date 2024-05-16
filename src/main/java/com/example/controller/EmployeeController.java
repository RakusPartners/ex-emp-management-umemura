package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Employee;
import com.example.form.LoginForm;
import com.example.form.UpdateEmployeeForm;
import com.example.service.EmployeeService;

import jakarta.servlet.http.HttpSession;

/**
 * 従業員情報を検索する処理を記述するcontrollerクラス
 * @author umemura
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private HttpSession session;

    /**
     * 従業員⼀覧を出⼒します
     * @param model
     * @return employee/list.html
     */
    @GetMapping("/showList")
    public String showList(Model model) {
        model.addAttribute("employeeList", employeeService.showList());
        return "employee/list";
    }
    @GetMapping("/showDetail")
    public String showDetail(String id, Model model, UpdateEmployeeForm form) {
        Employee employee = employeeService.showDetail(Integer.parseInt(id));
        model.addAttribute("employee", employee);
        return "employee/detail";
    }
    /**
     * 従業員詳細を更新します
     * @param form
     * @return /employee/showList.htmlにリダイレクト
     */
    @PostMapping("/update")
    public String update(UpdateEmployeeForm form) {
        String id = form.getId();
        String dependentsCount = form.getDependentsCount();

        if (id == null || id.isEmpty() || dependentsCount == null || dependentsCount.isEmpty()) {
            return "redirect:/employee/showList"; 
        }
        Employee employee = employeeService.showDetail(Integer.parseInt(id));
        employee.setDependentsCount(Integer.parseInt(dependentsCount));
        employeeService.update(employee);
        return "redirect:/employee/showList";
    }
    
}

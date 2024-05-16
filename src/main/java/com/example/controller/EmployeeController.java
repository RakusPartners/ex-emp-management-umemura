package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Employee;
import com.example.form.UpdateEmployeeForm;
import com.example.service.EmployeeService;

/**
 * 従業員情報を検索する処理を記述するcontrollerクラス
 * @author umemura
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

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
}

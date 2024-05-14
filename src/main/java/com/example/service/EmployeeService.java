package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Employee;
import com.example.repository.EmployeeRepository;

/**
 * 授業員情報⼀覧を全件検索する業務処理を⾏うメソッドを作成する serviceクラス
 * @author umemura
 */
@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

     /**
     * 従業員情報を全件取得します
     * @return employeeRepositoryのfindAll()メソッドからの戻り値
     */
    public List<Employee> showList() {
        return employeeRepository.findAll();
    }
     /**
     * 従業員情報を取得します
     * @param id ID
     * @return employeeRepositoryのload()メソッド
     */
    public Employee showDetail(Integer id) {
        return employeeRepository.load(id);
    }
}

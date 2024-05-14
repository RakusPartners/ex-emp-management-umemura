package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Employee;

/**
 * employeesテーブルを操作するrepositoryクラス
 * @author umemura
 */
@Repository
public class EmployeeRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<Employee> EMPLOYEE_ROW_MAPPER = (rs, i) -> {
        Employee employee = new Employee();
        employee.setId(rs.getInt("id"));
        employee.setName(rs.getString("name"));
        employee.setImage(rs.getString("image"));
        employee.setGender(rs.getString("gender"));
        employee.setHireDate(rs.getDate("hireDate"));
        employee.setMailAddress(rs.getString("mailAddress"));
        employee.setZipCode(rs.getString("zipCode"));
        employee.setAddress(rs.getString("address"));
        employee.setTelephone(rs.getString("telephone"));
        employee.setSalary(rs.getInt("salary"));
        employee.setCharacteristics(rs.getString("characteristics"));
        employee.setDependentsCount(rs.getInt("dependentsCount"));
        return employee;
    };
    /**
     * 従業員⼀覧情報を⼊社⽇順(降順)で取得します
     * @return 従業員一覧
     */
    public List<Employee> findAll() {
        String sql = "SELECT id, name, image, gender, hireDate, mailAddress, zipCode, address, telephone, salary, characteristics, dependentsCount FROM employees ORDER BY hireDate DESC";
        List<Employee> employeeList = template.query(sql, EMPLOYEE_ROW_MAPPER); 
        return employeeList;
    }
    /**
     * 主キーから従業員情報を取得します
     * @param id　ID
     * @return 従業員情報
     */
    public Employee load(Integer id) {
        String sql = "SELECT id, name, image, gender, hireDate, mailAddress, zipCode, address, telephone, salary, characteristics, dependentsCount FROM employees WHERE id=:id";
        SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
        Employee employee = template.queryForObject(sql, param, EMPLOYEE_ROW_MAPPER); 
        return employee;
    }
    /**
     * 従業員情報を変更します
     * @param employee　従業員情報
     */
    public void update(Employee employee) {
        String updateSql = "UPDATE employees SET name=:name, image=:image, gender=:gender, hireDate=:hireDate, mailAddress=:mailAddress, zipCode=:zipCode, address=:address, telephone=:telephone, salary=:salary, characteristics=:characteristics, dependentsCount=:dependentsCount WHERE id=:id";
        SqlParameterSource param = new BeanPropertySqlParameterSource(employee);
        template.update(updateSql, param);
    }
}
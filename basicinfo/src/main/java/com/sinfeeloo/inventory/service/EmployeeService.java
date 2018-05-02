package com.sinfeeloo.inventory.service;

import com.sinfeeloo.inventory.entity.Employee;
import com.sinfeeloo.inventory.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: mhj
 * @Desc:
 * @Date: 2018/5/2 15:55
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;


    public void addEmployee(Employee employee) {
        employeeMapper.insert(employee);
    }
}

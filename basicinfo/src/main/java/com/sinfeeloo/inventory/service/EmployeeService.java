package com.sinfeeloo.inventory.service;

import com.sinfeeloo.inventory.entity.Employee;
import com.sinfeeloo.inventory.entity.Paging;
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

    public void getEmployeeListByPage(Paging<Employee> paging) {
        paging.setTotal(employeeMapper.selectEmployeeListCount(paging.getSearchMap()));
        paging.setList(employeeMapper.selectEmployeeListByPage(paging.getSearchMap()));
    }

    public int modifyEmployee(Employee employee) {
        return employeeMapper.updateByPrimaryKey(employee);
    }

    public void deleteEmployee(Employee employee) {
        employeeMapper.deleteByPrimaryKey(employee);
    }
}

package com.sinfeeloo.inventory.controller;

import com.sinfeeloo.inventory.base.BaseController;
import com.sinfeeloo.inventory.entity.ComResp;
import com.sinfeeloo.inventory.entity.Employee;
import com.sinfeeloo.inventory.service.EmployeeService;
import com.sinfeeloo.inventory.utils.CommonUtils;
import com.sinfeeloo.inventory.utils.DateUtils;
import com.sinfeeloo.inventory.utils.PhoneFormatCheckUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: mhj
 * @Desc:员工管理
 * @Date: 2018/5/2 15:58
 */
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController extends BaseController {


    @Autowired
    private EmployeeService employeeService;


    /**
     * 添加员工
     *
     * @param name
     * @param code
     * @param idCard
     * @param mobile
     * @param sex
     * @param birthday
     * @param address
     * @param email
     * @param roleType
     * @param updater
     * @return
     */
    @PostMapping(value = "/addEmployee")
    public ComResp addEmployee(@RequestParam(value = "name") String name,
                               @RequestParam(value = "code") String code,
                               @RequestParam(value = "idCard", required = false) String idCard,
                               @RequestParam(value = "mobile") String mobile,
                               @RequestParam(value = "sex") Integer sex,
                               @RequestParam(value = "birthday", required = false) String birthday,
                               @RequestParam(value = "address", required = false) String address,
                               @RequestParam(value = "email", required = false) String email,
                               @RequestParam(value = "roleType") String roleType,
                               @RequestParam(value = "updater") String updater) {

        try {

            if (!PhoneFormatCheckUtils.isPhoneLegal(mobile)) {
                return ComResp.error("手机号格式不正确！");
            }
            if (sex != 1 && sex != 2) {
                return ComResp.error("性别不正确！");
            }
            if (!CommonUtils.isEmail(email)) {
                return ComResp.error("邮箱格式不正确！");
            }
            Employee employee = new Employee();
            employee.setName(name);
            employee.setCode(code);
            employee.setIdcard(idCard);
            employee.setMobile(mobile);
            employee.setSex(sex);
            employee.setBirthday(DateUtils.str2Date(birthday));
            employee.setEmail(email);
            employee.setAddress(address);
            employee.setType(roleType);
            employee.setUpdater(updater);
            employee.setState(1);
            employeeService.addEmployee(employee);
            return ComResp.success("添加成功！");
        } catch (Exception e) {
            return ComResp.success("添加失败！");
        }

    }
}

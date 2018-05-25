package com.sinfeeloo.inventory.controller;

import com.sinfeeloo.inventory.base.BaseController;
import com.sinfeeloo.inventory.entity.ComResp;
import com.sinfeeloo.inventory.entity.Employee;
import com.sinfeeloo.inventory.entity.Paging;
import com.sinfeeloo.inventory.entity.User;
import com.sinfeeloo.inventory.service.EmployeeService;
import com.sinfeeloo.inventory.utils.CommonUtils;
import com.sinfeeloo.inventory.utils.DateUtils;
import com.sinfeeloo.inventory.utils.PhoneFormatCheckUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
                               @RequestParam(value = "roleType") Integer roleType,
                               @RequestAttribute User user) {

        try {

            if (!PhoneFormatCheckUtils.isPhoneLegal(mobile)) {
                return ComResp.error("手机号格式不正确！");
            }
            if (sex != 1 && sex != 2) {
                return ComResp.error("性别不正确！");
            }
            if (!StringUtils.isBlank(email) && !CommonUtils.isEmail(email)) {
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
            employee.setUpdater(user.getEmployeeName());
            employee.setState(1);
            employeeService.addEmployee(employee);
            return ComResp.success("添加成功！");
        } catch (Exception e) {
            return ComResp.success("添加失败！");
        }

    }

    /**
     * 分页查询
     *
     * @param name
     * @param type
     * @param limit
     * @param page
     * @param sortCode
     * @param sortRole
     * @return
     */
    @GetMapping(value = "/getEmployeeListByPage")
    public ComResp getEmployeeListByPage(@RequestParam(value = "name", required = false) String name,
                                         @RequestParam(value = "mobile", required = false) String mobile,
                                         @RequestParam(value = "type", required = false) Integer type,
                                         @RequestParam(value = "limit", required = false, defaultValue = "20") Integer limit,
                                         @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                         @RequestParam(value = "sortCode", required = false, defaultValue = "id") String sortCode,
                                         @RequestParam(value = "sortRole", required = false, defaultValue = "ASC") String sortRole) {
        Paging<Employee> paging = new Paging<>(page, limit);
        try {
            paging.putSearch("name", name);
            paging.putSearch("mobile", mobile);
            paging.putSearch("type", type);
            paging.putSearch("limit", limit);
            paging.putSearch("page", page);
            paging.putSearch("sortCode", sortCode);
            paging.putSearch("sortRole", sortRole);
            employeeService.getEmployeeListByPage(paging);
            return ComResp.success("查询成功！", paging);
        } catch (Exception e) {
            return ComResp.error("查询失败！", e);
        }

    }


    /**
     * 修改员工
     *
     * @param id
     * @param name
     * @param code
     * @param idCard
     * @param mobile
     * @param sex
     * @param birthday
     * @param address
     * @param email
     * @param roleType
     * @return
     */
    @PostMapping(value = "/modifyEmployee")
    public ComResp modifyEmployee(@RequestParam(value = "id") Integer id,
                                  @RequestParam(value = "name") String name,
                                  @RequestParam(value = "code") String code,
                                  @RequestParam(value = "idCard", required = false) String idCard,
                                  @RequestParam(value = "mobile") String mobile,
                                  @RequestParam(value = "sex") Integer sex,
                                  @RequestParam(value = "birthday", required = false) String birthday,
                                  @RequestParam(value = "address", required = false) String address,
                                  @RequestParam(value = "email", required = false) String email,
                                  @RequestParam(value = "roleType") Integer roleType,
                                  @RequestAttribute User user) {

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
            employee.setId(id);
            employee.setName(name);
            employee.setCode(code);
            employee.setIdcard(idCard);
            employee.setMobile(mobile);
            employee.setSex(sex);
            employee.setBirthday(DateUtils.str2Date(birthday));
            employee.setEmail(email);
            employee.setAddress(address);
            employee.setType(roleType);
            employee.setUpdater(user.getEmployeeName());
            int num = employeeService.modifyEmployee(employee);
            return num > 0 ? ComResp.success("修改成功！") : ComResp.error("修改失败！");
        } catch (Exception e) {
            return ComResp.success("修改失败！");
        }

    }

    /**
     * 删除员工
     *
     * @param id
     * @return
     */
    @PostMapping(value = "/deleteEmployee")
    public ComResp deleteEmployee(@RequestParam(value = "id") Integer id,
                                  @RequestAttribute User userr) {

        try {
            Employee employee = new Employee();
            employee.setId(id);
            employee.setUpdater(userr.getEmployeeName());
            employeeService.deleteEmployee(employee);
            return ComResp.success("删除成功！");
        } catch (Exception e) {
            return ComResp.success("删除失败！");
        }

    }


    /**
     * 员工详情
     *
     * @return
     */
    @GetMapping(value = "/getEmployeeDetail")
    public ComResp getEmployeeListByPage(@RequestParam(value = "id", required = false) Integer id) {
        try {
            Employee employee = employeeService.getEmployeeDetail(id);
            return ComResp.success("查询成功！", employee);
        } catch (Exception e) {
            return ComResp.error("查询失败！", e);
        }

    }


}

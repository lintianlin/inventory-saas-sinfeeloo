package com.sinfeeloo.inventory.config;

import com.alibaba.fastjson.JSONObject;
import com.sinfeeloo.inventory.entity.User;
import com.sinfeeloo.inventory.mapper.UserMapper;
import com.sinfeeloo.inventory.utils.JWTUtil;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpMethod;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

public class StatelessAuthcFilter extends AccessControlFilter {

    private UserMapper userMapper;

    /**
     * 拦截器权限允许
     * @param request
     * @param response
     * @param mappedValue
     * @return
     */
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        HttpServletRequest hsRequest = (HttpServletRequest) request;
        String method = hsRequest.getMethod();
        //传递自定义header时跨域请求会先发送预检验（Option）请求（不包含参数）
        //这种情况下需要跳过shiro拦截器中的权限判断执行下一个拦截器CorsFilter
        if (method.equals(HttpMethod.OPTIONS.name())) {
            return true;
        }
        return false;
    }

    /**
     * 拦截器权限拒绝
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        //1、客户端传递的token, 修改为在header里验证
        HttpServletRequest hsRequest = (HttpServletRequest) request;
        String token = hsRequest.getHeader("token");
        String callbackFunction = request.getParameter("callbackparams");
        try {
            if (StringUtils.isBlank(token)) {
                onLoginFail(response, callbackFunction);
                return false;
            }
            JWTUtil.verify(token);
            String acount = JWTUtil.getUsername(token);
            User user = userMapper.selectByAccount(acount);
            if (user == null) {
                onLoginFail(response, callbackFunction);
                return false;
            }
            request.setAttribute("user", user);

        } catch (Exception e) {
            onLoginFail(response, callbackFunction);
            return false;
        }
        return true;
    }

    //认证失败时处理方法
    private void onLoginFail(ServletResponse response, String callbackFunction) throws IOException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setCharacterEncoding("utf8");
        JSONObject json = new JSONObject(true);
        json.put("rc", "0");
        json.put("des", "token无效！");
        if (StringUtils.isBlank(callbackFunction)) {//不是ajax的jsonp请求
            httpResponse.setContentType("application/json");
            httpResponse.getWriter().write(json.toJSONString());
            System.out.println(json.toJSONString());
            return;
        }
        httpResponse.setContentType("text/javascript");
        System.out.println(callbackFunction + "(" + json.toJSONString() + ")");
        httpResponse.getWriter().write(callbackFunction + "(" + json.toJSONString() + ")");

    }

    /*
     * 预处理阶段 初始化userMapper
     */
    @Override
    public boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        ServletContext context = request.getServletContext();
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
        userMapper = ctx.getBean(UserMapper.class);
        return super.onPreHandle(request, response, mappedValue);
    }


}
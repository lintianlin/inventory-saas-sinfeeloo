package com.sinfeeloo.inventory.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SessionStorageEvaluator;
import org.apache.shiro.mgt.SubjectFactory;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSubjectFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;
import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

/**
 * ShiroConfiguration
 * @Author: mhj
 * @Desc:  shiro配置 无seesion
 * @Date: 2018/4/25 15:37
 */
@Configuration
public class ShiroConfiguration {

    //自定义 Shiro Realm
    @Bean
    public UserRealm myShiroRealm() {
        UserRealm myShiroRealm = new UserRealm();
        myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return myShiroRealm;
    }

    // 安全管理器
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm
        securityManager.setRealm(myShiroRealm());
        // session管理器
        DefaultSessionManager sessionManager = new DefaultSessionManager();
        sessionManager.setSessionValidationSchedulerEnabled(false);// 禁用会话调度器
        securityManager.setSessionManager(sessionManager);

        // SubjectDAO
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        subjectDAO.setSessionStorageEvaluator(new SessionStorageEvaluator() {
            @Override
            // 禁用使用Sessions 作为存储策略的实现
            public boolean isSessionStorageEnabled(Subject paramSubject) {
                return false;
            }
        });
        securityManager.setSubjectDAO(subjectDAO);

        // Subject工厂
        SubjectFactory SubjectFactory = new DefaultWebSubjectFactory() {
            @Override
            public Subject createSubject(SubjectContext subjectContext) {
                subjectContext.setSessionCreationEnabled(false);// 不创建session
                return super.createSubject(subjectContext);
            }
        };
        securityManager.setSubjectFactory(SubjectFactory);

        return securityManager;
    }

    // 凭证匹配器 指定加密方式
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("SHA-1");// 散列算法:这里使用SHA-1算法;
        hashedCredentialsMatcher.setHashIterations(1);// 散列的次数，比如散列两次，相当于
        // SHA-1(SHA-1(""));
        return hashedCredentialsMatcher;
    }

    //ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean shiroFilter() {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager());//设置securityManager
        //注册自定义过滤器
        AccessControlFilter statelessAuthcFilter = new StatelessAuthcFilter();
        Map<String, Filter> filters = new HashMap<>();
        filters.put("statelessAuthcFilter", statelessAuthcFilter);
        factoryBean.setFilters(filters);
        //设置  拦截链
        Map<String, String> filterChainDefinitionMap = new HashMap<>();
        filterChainDefinitionMap.put("/**", "statelessAuthcFilter");//其他 都拦截 statelessAuthcFilter
        filterChainDefinitionMap.put("/user/login", "anon");
        filterChainDefinitionMap.put("/images/tmp/*", "anon");

        factoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return factoryBean;
    }

}

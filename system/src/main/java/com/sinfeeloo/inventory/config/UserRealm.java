package com.sinfeeloo.inventory.config;

import com.sinfeeloo.inventory.entity.User;
import com.sinfeeloo.inventory.mapper.UserMapper;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义  Shiro  Realm
 * 
 * @author chenmw 
 * @date 2017年4月12日 上午10:48:12
 */
public class UserRealm extends AuthorizingRealm {
	
	
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 提供账户信息返回认证信息
	 * 
	 * @see AuthenticatingRealm#doGetAuthenticationInfo(AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token){
		   //获取用户账户
	       String account = (String)token.getPrincipal();
	       User user = userMapper.selectByAccount(account);
	       if(user == null){
	           return null;
	       }
	       //加密方式;
	       SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
	              user.getAccount(), //用户名
	              user.getPassword(), //密码
	              getName()  //realm name
	        );
			return authenticationInfo;
	}

	//权限资源角色
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String account = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//add Permission Resources
		//info.setStringPermissions(userService.findPermissions(username));
		//add Roles String[Set<String> roles]
		//info.setRoles(roles);
		return info;
	}

}

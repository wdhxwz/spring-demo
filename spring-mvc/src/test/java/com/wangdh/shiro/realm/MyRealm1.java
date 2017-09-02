package com.wangdh.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

/**
 * Shiro从Realm获取安全数据(如用户、角色、权限)
 * <p>
 * SecurityManager要验证用户身份，需要从Realm获取相应用户进行比较以确定用户身份是否合法
 * <p>
 * 也需要从Realm得到用户的角色/权限以验证用户是否能进行操作
 * 
 * @author wdhcxx
 *
 */
public class MyRealm1 implements Realm {

	@Override
	public String getName() {
		return "MyRealm1";
	}

	@Override
	public boolean supports(AuthenticationToken token) {
		return token instanceof UsernamePasswordToken;
	}

	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName = (String) token.getPrincipal();
		String password = new String((char[])token.getCredentials()); 
		if (!"zhang".equals(userName)) {
			throw new UnknownAccountException();
		}
		if (!"123".equals(password)) {
			throw new IncorrectCredentialsException();
		}

		return new SimpleAuthenticationInfo(userName, password, getName());
	}
}

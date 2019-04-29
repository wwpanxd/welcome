package com.bootdo.system.shiro;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.bootdo.common.config.ApplicationContextRegister;
import com.bootdo.system.domain.UserToken;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.bootdo.common.utils.ShiroUtils;
import com.bootdo.system.dao.UserDao;
import com.bootdo.system.domain.UserDO;
import com.bootdo.system.service.MenuService;
import com.bootdo.system.service.UserService;
import com.bootdo.welcome.domain.admin.YXUserDO;
import com.bootdo.welcome.service.admin.YXMenuService;
import com.bootdo.welcome.service.admin.YXUserService;

public class UserRealm extends AuthorizingRealm {
	
	@Autowired
	UserService userservice;
	@Autowired
	YXUserService yxuserservice;
	@Autowired
	MenuService menuService;
	@Autowired
	YXMenuService yxmenuService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		//获取学校编码
		Integer uvcode = ShiroUtils.getUserUVCode();
		Long userId = ShiroUtils.getUserId();
		if(uvcode==100000) {
			//系统管理员登录、获取权限列表
//			MenuService menuService = ApplicationContextRegister.getBean(MenuService.class);
			Set<String> perms = menuService.listPerms(userId);
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			info.setStringPermissions(perms);
			return info;
		}
		else {
			//获取迎新人员的管理权限
			
			Set<String> perms = yxmenuService.listPerms(userId);
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			info.setStringPermissions(perms);
			return info;
		}
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String loginname = (String) token.getPrincipal();
		String password = new String((char[]) token.getCredentials());
		//兼容管理员和迎新业务登录
		LoginUserDO loginuser= new LoginUserDO();
		
		if(StringUtils.startsWith(loginname, "100000")) {
			//系统管理登录
//			UserDao userMapper = ApplicationContextRegister.getBean(UserDao.class);
			// 查询用户信息
			UserDO user = userservice.findOneByLoginName(StringUtils.substring(loginname, 6));
			
			// 账号不存在
			if (user == null) {
				throw new UnknownAccountException("账号或密码不正确");
			}

			// 密码错误
			if (!password.equals(user.getPassword())) {
				throw new IncorrectCredentialsException("账号或密码不正确");
			}

			// 账号锁定
			if (user.getStatus() == 0) {
				throw new LockedAccountException("账号已被锁定,请联系管理员");
			}
			
			loginuser=new LoginUserDO(user.getUserId(),user.getUsername(),user.getName(),user.getPassword(),100000);
		}
		else {
			//学校迎新人员登录
			// 查询用户信息
			YXUserDO user = yxuserservice.findOneByLoginName(Integer.parseInt(StringUtils.substring(loginname, 0,6)),StringUtils.substring(loginname, 6));
			
			// 账号不存在
			if (user == null) {
				throw new UnknownAccountException("账号或密码不正确");
			}

			// 密码错误
			if (!password.equals(user.getPassword())) {
				throw new IncorrectCredentialsException("账号或密码不正确");
			}

			// 账号锁定
			if (user.getFlag() == 0) {
				throw new LockedAccountException("账号已被锁定,请联系管理员");
			}
			
			loginuser=new LoginUserDO(user.getId(),user.getLoginname(),user.getName(),user.getPassword(),user.getUvCode());
		}

		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(loginuser, password, getName());
		return info;
	}

}

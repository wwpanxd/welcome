package com.bootdo.common.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.bootdo.common.exception.ExceptionHandler;
import com.bootdo.common.exception.ValidateCode;
import com.bootdo.common.exception.ValidateMessage;
import com.bootdo.common.utils.ShiroUtils;
import com.bootdo.system.shiro.LoginUserDO;

@Controller
public class BaseController {
	
	@Autowired
	ValidateMessage validateMessage;
	
	public LoginUserDO getUser() {
		if(ShiroUtils.getUser()==null)
			ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.USER_SESSION_TIMEOUT));
		
		return ShiroUtils.getUser();
	}

	public Long getUserId() {
		return getUser().getUserId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}
	
	public Integer getUvCode() {
		return getUser().getUvCode();
	}
}
package com.bootdo.welcome.vo;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="LoginVO",description="用户登录")
public class LoginVO implements Serializable{

	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value="用户登录名")
	 String username;
	@ApiModelProperty(value="用户密码")
	 String password;
	@ApiModelProperty(value = "学校的唯一编码")
	 Integer uvcode;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getUvcode() {
		return uvcode;
	}
	public void setUvcode(Integer uvcode) {
		this.uvcode = uvcode;
	}
}

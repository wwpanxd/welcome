package com.bootdo.welcome.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class SchoolUserRoleVO implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "角色名称")
	private String roleName;
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}

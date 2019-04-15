package com.bootdo.welcome.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="SchoolUserRoleDo",description="用户角色")
public class SchoolUserRoleDo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long id;
	@ApiModelProperty(value="角色名称")
	private String roleName;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}

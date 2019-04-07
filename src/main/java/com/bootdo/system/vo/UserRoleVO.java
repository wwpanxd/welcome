package com.bootdo.system.vo;

import io.swagger.annotations.ApiModel;

@ApiModel(value="UserRolesVO",description="角色添加用户时,入参使用")
public class UserRoleVO {

	private Long userid;
	private Long roleid;
	
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public Long getRoleid() {
		return roleid;
	}
	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}
}

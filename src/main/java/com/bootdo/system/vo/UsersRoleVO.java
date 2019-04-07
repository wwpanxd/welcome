package com.bootdo.system.vo;

import java.util.List;

import io.swagger.annotations.ApiModel;

@ApiModel(value="UsersRoleVO",description="角色批量添加用户时,入参使用")
public class UsersRoleVO {

	private List<Long> userid;
	private Long roleid;
	
	public List<Long> getUserid() {
		return userid;
	}
	public void setUserid(List<Long> userid) {
		this.userid = userid;
	}
	public Long getRoleid() {
		return roleid;
	}
	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}
	
	
}

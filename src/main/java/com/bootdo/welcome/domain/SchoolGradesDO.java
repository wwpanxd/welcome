package com.bootdo.welcome.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class SchoolGradesDO implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;
	@ApiModelProperty(value = "班级名字")
	private String name;
	@ApiModelProperty(value = "班级人数")
	private long userCount;
	@ApiModelProperty(value = "班主任名字")
	private String headMaster;
	@ApiModelProperty(value = "班主任电话")
	private String headMasterPhone;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getUserCount() {
		return userCount;
	}

	public void setUserCount(long userCount) {
		this.userCount = userCount;
	}

	public String getHeadMaster() {
		return headMaster;
	}

	public void setHeadMaster(String headMaster) {
		this.headMaster = headMaster;
	}

	public String getHeadMasterPhone() {
		return headMasterPhone;
	}

	public void setHeadMasterPhone(String headMasterPhone) {
		this.headMasterPhone = headMasterPhone;
	}
}

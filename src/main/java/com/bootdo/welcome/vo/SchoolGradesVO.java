package com.bootdo.welcome.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="SchoolGradesVO",description="新增班级")
public class SchoolGradesVO implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "班级名字")
	private String name;
	@ApiModelProperty(value = "班级人数")
	private long userCount;
	@ApiModelProperty(value = "班主任名字")
	private String headMaster;
	@ApiModelProperty(value = "班主任电话")
	private String headMasterPhone;
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

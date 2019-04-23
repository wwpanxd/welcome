package com.bootdo.welcome.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="SchoolOrganizationVO",description="新增机构")
public class SchoolOrganizationVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	@ApiModelProperty(value = "机构类型")
	private int type;
	@ApiModelProperty(value = "机构父id")
	private int parentId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
}

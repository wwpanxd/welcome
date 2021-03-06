package com.bootdo.welcome.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class SchoolOrganizationDO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	@ApiModelProperty(value = "机构名字")
	private String name;
	@ApiModelProperty(value = "机构类型")
	private int type;
	@ApiModelProperty(value = "机构父id")
	private int parentId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public long getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
}

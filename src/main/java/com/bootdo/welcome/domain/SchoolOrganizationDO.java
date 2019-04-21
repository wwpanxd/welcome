package com.bootdo.welcome.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class SchoolOrganizationDO implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	@ApiModelProperty(value = "机构名字")
	private String name;
	@ApiModelProperty(value = "机构类型")
	private long type;
	@ApiModelProperty(value = "机构父id")
	private long parentId;

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

	public long getType() {
		return type;
	}

	public void setType(long type) {
		this.type = type;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
}

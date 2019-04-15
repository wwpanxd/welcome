package com.bootdo.welcome.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class SchoolProfessionDO implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;
	@ApiModelProperty(value = "专业名称")
	private String professionName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProfessionName() {
		return professionName;
	}

	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}
}

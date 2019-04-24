package com.bootdo.welcome.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class StuTakeStationDO implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "")
	private Long id;
	// 学生唯一编码
	@ApiModelProperty(value = "学生唯一编码")
	private String sCode;
	// 学校唯一编码
	@ApiModelProperty(value = "学校唯一编码")
	private Integer uvCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getsCode() {
		return sCode;
	}

	public void setsCode(String sCode) {
		this.sCode = sCode;
	}

	public Integer getUvCode() {
		return uvCode;
	}

	public void setUvCode(Integer uvCode) {
		this.uvCode = uvCode;
	}
}

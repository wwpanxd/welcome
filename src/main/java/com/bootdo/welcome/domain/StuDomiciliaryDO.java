package com.bootdo.welcome.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "StuDomiciliaryDO", description = "学生籍贯信息表")
public class StuDomiciliaryDO implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "")
	private Long id;
	// 学校的唯一编码
	@ApiModelProperty(value = "学校的唯一编码")
	private Integer uvCode;
	// 学生ID
	@ApiModelProperty(value = "学生ID")
	private Integer sId;
	// 常住地址
	@ApiModelProperty(value = "常住地址")
	private String address;
	// 出生地址
	@ApiModelProperty(value = "出生地址")
	private String birthAddress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getUvCode() {
		return uvCode;
	}

	public void setUvCode(Integer uvCode) {
		this.uvCode = uvCode;
	}

	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthAddress() {
		return birthAddress;
	}

	public void setBirthAddress(String birthAddress) {
		this.birthAddress = birthAddress;
	}
}

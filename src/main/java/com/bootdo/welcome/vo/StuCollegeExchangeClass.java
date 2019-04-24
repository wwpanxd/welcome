package com.bootdo.welcome.vo;

import com.sun.tools.javac.util.List;

import io.swagger.annotations.ApiModelProperty;

public class StuCollegeExchangeClass {
	// 学生唯一编码 sCode
	@ApiModelProperty(value = "学生唯一编码List")
	private List<String> list;
	
	// 班号
	@ApiModelProperty(value = "班号")
	private String clCode;

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public String getClCode() {
		return clCode;
	}

	public void setClCode(String clCode) {
		this.clCode = clCode;
	}
}

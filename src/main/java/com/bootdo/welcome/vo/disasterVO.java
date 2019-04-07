package com.bootdo.welcome.vo;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="disasterVO",description="灾害类型信息")
public class disasterVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value="灾害类型名称")
	String name;
	@ApiModelProperty(value="灾害类型值")
	String value;
	@ApiModelProperty(value="子灾害类型列表")
	List<disasterVO> dslist;
	
	public disasterVO(String name,String value,List<disasterVO> dslist) {
		this.name=name;
		this.value=value;
		this.dslist=dslist;
	}
	public disasterVO(String name,String value) {
		this.name=name;
		this.value=value;
	}
	public disasterVO() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public List<disasterVO> getDslist() {
		return dslist;
	}
	public void setDslist(List<disasterVO> dslist) {
		this.dslist = dslist;
	}
}

package com.bootdo.welcome.utils;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="BatchEnabledInput",description="批量启用禁用")
public class RF implements Serializable{

	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value="0:成功,1:失败")
	private Integer code;
	@ApiModelProperty(value="描述")
	private String  des;
	@ApiModelProperty(value="对应url")
	private List<String> url;
	
	public RF() {
		
	}
	public RF(Integer code, String des, List<String> url) {
		super();
		this.code = code;
		this.des = des;
		this.url = url;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public List<String> getUrl() {
		return url;
	}
	public void setUrl(List<String> url) {
		this.url = url;
	}
	
}

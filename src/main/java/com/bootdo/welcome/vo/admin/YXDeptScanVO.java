package com.bootdo.welcome.vo.admin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "YXDeptScanVO", description = "组织机构搜索入参") 
public class YXDeptScanVO {
	
	@ApiModelProperty(value = "学校的唯一编码",required=true)
	private Integer uvCode;
	@ApiModelProperty(value = "部门名称")
	private String dName;
	@ApiModelProperty(value = "是否启用")
	private Integer dFlag;
	
	
	public Integer getUvCode() {
		return uvCode;
	}
	public void setUvCode(Integer uvCode) {
		this.uvCode = uvCode;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public Integer getdFlag() {
		return dFlag;
	}
	public void setdFlag(Integer dFlag) {
		this.dFlag = dFlag;
	}
}

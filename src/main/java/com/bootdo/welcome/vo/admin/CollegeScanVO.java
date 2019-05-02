package com.bootdo.welcome.vo.admin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CollegeScanVO", description = "院系机构搜索入参") 
public class CollegeScanVO {
	@ApiModelProperty(value = "学校唯一编码")
	private Integer uvCode;
	//院系级别
	@ApiModelProperty(value = "院系级别")
	private Integer cLevel;
	//上级部门ID，一级部门为0
	@ApiModelProperty(value = "上级部门ID，一级部门为0")
	private Long parentId;
	//院系名称
	@ApiModelProperty(value = "院系名称")
	private String cName;
	//专业编号
	@ApiModelProperty(value = "专业编号")
	private String cCode;
	
	
	public Integer getUvCode() {
		return uvCode;
	}
	public void setUvCode(Integer uvCode) {
		this.uvCode = uvCode;
	}
	public Integer getcLevel() {
		return cLevel;
	}
	public void setcLevel(Integer cLevel) {
		this.cLevel = cLevel;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcCode() {
		return cCode;
	}
	public void setcCode(String cCode) {
		this.cCode = cCode;
	}
}

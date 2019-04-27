package com.bootdo.welcome.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "StuPoliticalOutlookDO", description = "政治面貌信息表")
public class StuPoliticalOutlookDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "")
	private Long id;
	// 学生唯一编码
	@ApiModelProperty(value = "学生唯一编码")
	private String sCode;
	// 学校唯一编码
	@ApiModelProperty(value = "学校唯一编码")
	private Integer uvCode;
	// 政治面貌名称
	@ApiModelProperty(value = "政治面貌名称")
	private String poName;

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

	public String getPoName() {
		return poName;
	}

	public void setPoName(String poName) {
		this.poName = poName;
	}
}

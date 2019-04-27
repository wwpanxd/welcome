package com.bootdo.welcome.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

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
}

package com.bootdo.welcome.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class AchievementDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "")
	private Long id;
	// 学校的唯一编码
	@ApiModelProperty(value = "学校的唯一编码")
	private String uvCode;

	// 学生唯一编码
	@ApiModelProperty(value = "学生唯一编码")
	private String sCode;

	// 学生唯一编码
	@ApiModelProperty(value = "科目唯一编码")
	private Long SubjectId;

	// 成绩
	@ApiModelProperty(value = "成绩")
	private String value;
}

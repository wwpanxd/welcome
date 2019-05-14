package com.bootdo.welcome.domain;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * 新生成绩表
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-05-14 13:19:14
 */
@ApiModel(value = "StuScoreDO", description = "新生成绩表") 
public class StuScoreDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	@ApiModelProperty(value = "")
	private Long id;
	//学校唯一编码
	@ApiModelProperty(value = "学校唯一编码")
	private Integer uvCode;
	//考试科目
	@ApiModelProperty(value = "考试科目")
	private String eSubject;
	//成绩
	@ApiModelProperty(value = "成绩")
	private Double sScore;
	//学生ID
	@ApiModelProperty(value = "学生ID")
	private Long sId;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：学校唯一编码
	 */
	public void setUvCode(Integer uvCode) {
		this.uvCode = uvCode;
	}
	/**
	 * 获取：学校唯一编码
	 */
	public Integer getUvCode() {
		return uvCode;
	}
	/**
	 * 设置：考试科目
	 */
	public void setESubject(String eSubject) {
		this.eSubject = eSubject;
	}
	/**
	 * 获取：考试科目
	 */
	public String getESubject() {
		return eSubject;
	}
	/**
	 * 设置：成绩
	 */
	public void setSScore(Double sScore) {
		this.sScore = sScore;
	}
	/**
	 * 获取：成绩
	 */
	public Double getSScore() {
		return sScore;
	}
	/**
	 * 设置：学生ID
	 */
	public void setSId(Long sId) {
		this.sId = sId;
	}
	/**
	 * 获取：学生ID
	 */
	public Long getSId() {
		return sId;
	}
}

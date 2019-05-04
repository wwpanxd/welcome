package com.bootdo.welcome.domain;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * 
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-05-03 16:17:01
 */
@ApiModel(value = "ErScoreDO", description = "") 
public class ErScoreDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增主键
	@ApiModelProperty(value = "自增主键")
	private Long id;
	//考试科目
	@ApiModelProperty(value = "考试科目")
	private String eSubject;
	//学校唯一编码
	@ApiModelProperty(value = "学校唯一编码")
	private Integer uvCode;
	//成绩
	@ApiModelProperty(value = "成绩")
	private Double esScore;
	//学生唯一编码
	@ApiModelProperty(value = "学生唯一编码")
	private String sCode;
	//临时考号
	@ApiModelProperty(value = "临时考号")
	private String sExCode;

	/**
	 * 设置：自增主键
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：自增主键
	 */
	public Long getId() {
		return id;
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
	 * 设置：成绩
	 */
	public void setEsScore(Double esScore) {
		this.esScore = esScore;
	}
	/**
	 * 获取：成绩
	 */
	public Double getEsScore() {
		return esScore;
	}
	/**
	 * 设置：学生唯一编码
	 */
	public void setSCode(String sCode) {
		this.sCode = sCode;
	}
	/**
	 * 获取：学生唯一编码
	 */
	public String getSCode() {
		return sCode;
	}
	/**
	 * 设置：临时考号
	 */
	public void setSExCode(String sExCode) {
		this.sExCode = sExCode;
	}
	/**
	 * 获取：临时考号
	 */
	public String getSExCode() {
		return sExCode;
	}
}

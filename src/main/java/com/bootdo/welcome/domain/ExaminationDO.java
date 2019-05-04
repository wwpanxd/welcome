package com.bootdo.welcome.domain;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * 普教考试任务表
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-05-03 16:17:01
 */
@ApiModel(value = "ExaminationDO", description = "普教考试任务表") 
public class ExaminationDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	@ApiModelProperty(value = "")
	private Long id;
	//考试任务简称
	@ApiModelProperty(value = "考试任务简称")
	private String eName;
	//考试科目编码
	@ApiModelProperty(value = "考试科目编码")
	private String eSubjectCode;
	//考试科目
	@ApiModelProperty(value = "考试科目")
	private String eSubject;
	//考试开始时间
	@ApiModelProperty(value = "考试开始时间")
	private Long eStime;
	//考试结束时间
	@ApiModelProperty(value = "考试结束时间")
	private Long eEtime;
	//启用禁用0:禁用,1:启用
	@ApiModelProperty(value = "启用禁用0:禁用,1:启用")
	private Integer eFlag;
	//学校唯一编码
	@ApiModelProperty(value = "学校唯一编码")
	private Integer uvCode;
	//考试范围描述
	@ApiModelProperty(value = "考试范围描述")
	private String eStudents;
	//考场范围描述
	@ApiModelProperty(value = "考场范围描述")
	private String eRooms;

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
	 * 设置：考试任务简称
	 */
	public void setEName(String eName) {
		this.eName = eName;
	}
	/**
	 * 获取：考试任务简称
	 */
	public String getEName() {
		return eName;
	}
	/**
	 * 设置：考试科目编码
	 */
	public void setESubjectCode(String eSubjectCode) {
		this.eSubjectCode = eSubjectCode;
	}
	/**
	 * 获取：考试科目编码
	 */
	public String getESubjectCode() {
		return eSubjectCode;
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
	 * 设置：考试开始时间
	 */
	public void setEStime(Long eStime) {
		this.eStime = eStime;
	}
	/**
	 * 获取：考试开始时间
	 */
	public Long getEStime() {
		return eStime;
	}
	/**
	 * 设置：考试结束时间
	 */
	public void setEEtime(Long eEtime) {
		this.eEtime = eEtime;
	}
	/**
	 * 获取：考试结束时间
	 */
	public Long getEEtime() {
		return eEtime;
	}
	/**
	 * 设置：启用禁用0:禁用,1:启用
	 */
	public void setEFlag(Integer eFlag) {
		this.eFlag = eFlag;
	}
	/**
	 * 获取：启用禁用0:禁用,1:启用
	 */
	public Integer getEFlag() {
		return eFlag;
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
	 * 设置：考试范围描述
	 */
	public void setEStudents(String eStudents) {
		this.eStudents = eStudents;
	}
	/**
	 * 获取：考试范围描述
	 */
	public String getEStudents() {
		return eStudents;
	}
	/**
	 * 设置：考场范围描述
	 */
	public void setERooms(String eRooms) {
		this.eRooms = eRooms;
	}
	/**
	 * 获取：考场范围描述
	 */
	public String getERooms() {
		return eRooms;
	}
}

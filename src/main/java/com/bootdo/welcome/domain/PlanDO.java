package com.bootdo.welcome.domain;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 迎新计划表
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:55:53
 */
@ApiModel(value = "PlanDO", description = "迎新计划表") 
public class PlanDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	@ApiModelProperty(value = "")
	private Long id;
	//学校的唯一编码
	@ApiModelProperty(value = "学校的唯一编码")
	private String uvCode;
	//院系级别
	@ApiModelProperty(value = "院系级别")
	private Integer cLevel;
	//机构ID
	@ApiModelProperty(value = "机构ID")
	private Integer cId;
	//迎新计划名称
	@ApiModelProperty(value = "迎新计划名称")
	private String pName;
	//计划开始时间
	@ApiModelProperty(value = "计划开始时间")
	private Long pStime;
	//计划结束时间
	@ApiModelProperty(value = "计划结束时间")
	private Long pEtime;
	//计划状态(0:禁用,1:启用)
	@ApiModelProperty(value = "计划状态(0:禁用,1:启用)")
	private Integer pStatus;

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
	 * 设置：学校的唯一编码
	 */
	public void setUvCode(String uvCode) {
		this.uvCode = uvCode;
	}
	/**
	 * 获取：学校的唯一编码
	 */
	public String getUvCode() {
		return uvCode;
	}
	/**
	 * 设置：院系级别
	 */
	public void setCLevel(Integer cLevel) {
		this.cLevel = cLevel;
	}
	/**
	 * 获取：院系级别
	 */
	public Integer getCLevel() {
		return cLevel;
	}
	/**
	 * 设置：机构ID
	 */
	public void setCId(Integer cId) {
		this.cId = cId;
	}
	/**
	 * 获取：机构ID
	 */
	public Integer getCId() {
		return cId;
	}
	/**
	 * 设置：迎新计划名称
	 */
	public void setPName(String pName) {
		this.pName = pName;
	}
	/**
	 * 获取：迎新计划名称
	 */
	public String getPName() {
		return pName;
	}
	/**
	 * 设置：计划开始时间
	 */
	public void setPStime(Long pStime) {
		this.pStime = pStime;
	}
	/**
	 * 获取：计划开始时间
	 */
	public Long getPStime() {
		return pStime;
	}
	/**
	 * 设置：计划结束时间
	 */
	public void setPEtime(Long pEtime) {
		this.pEtime = pEtime;
	}
	/**
	 * 获取：计划结束时间
	 */
	public Long getPEtime() {
		return pEtime;
	}
	/**
	 * 设置：计划状态(0:禁用,1:启用)
	 */
	public void setPStatus(Integer pStatus) {
		this.pStatus = pStatus;
	}
	/**
	 * 获取：计划状态(0:禁用,1:启用)
	 */
	public Integer getPStatus() {
		return pStatus;
	}
}

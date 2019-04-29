package com.bootdo.welcome.domain;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * 迎新阶段表
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-29 11:42:24
 */
@ApiModel(value = "StageDO", description = "迎新阶段表") 
public class StageDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	@ApiModelProperty(value = "id")
	private Long id;
	//学校唯一编码
	@ApiModelProperty(value = "学校唯一编码")
	private Integer uvCode;
	//阶段级别(字典数据)
	@ApiModelProperty(value = "阶段级别(字典数据)")
	private Integer sLevel;
	//阶段名称
	@ApiModelProperty(value = "阶段名称")
	private String sName;
	//阶段说明
	@ApiModelProperty(value = "阶段说明")
	private String sDescription;
	//阶段时间段说明
	@ApiModelProperty(value = "阶段时间段说明")
	private String sTime;
	//阶段开始时间
	@ApiModelProperty(value = "阶段开始时间")
	private Date sStime;
	//阶段结束时间
	@ApiModelProperty(value = "阶段结束时间")
	private Date sEtime;
	//阶段完成进度 (1-100)
	@ApiModelProperty(value = "阶段完成进度 (1-100)")
	private Integer sProgress;
	//阶段菜单唯一编码
	@ApiModelProperty(value = "阶段菜单唯一编码")
	private Integer sMcode;
	//阶段管理人员说明
	@ApiModelProperty(value = "阶段管理人员说明")
	private String sManager;

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
	 * 设置：阶段级别(字典数据)
	 */
	public void setSLevel(Integer sLevel) {
		this.sLevel = sLevel;
	}
	/**
	 * 获取：阶段级别(字典数据)
	 */
	public Integer getSLevel() {
		return sLevel;
	}
	/**
	 * 设置：阶段名称
	 */
	public void setSName(String sName) {
		this.sName = sName;
	}
	/**
	 * 获取：阶段名称
	 */
	public String getSName() {
		return sName;
	}
	/**
	 * 设置：阶段说明
	 */
	public void setSDescription(String sDescription) {
		this.sDescription = sDescription;
	}
	/**
	 * 获取：阶段说明
	 */
	public String getSDescription() {
		return sDescription;
	}
	/**
	 * 设置：阶段时间段说明
	 */
	public void setSTime(String sTime) {
		this.sTime = sTime;
	}
	/**
	 * 获取：阶段时间段说明
	 */
	public String getSTime() {
		return sTime;
	}
	/**
	 * 设置：阶段开始时间
	 */
	public void setSStime(Date sStime) {
		this.sStime = sStime;
	}
	/**
	 * 获取：阶段开始时间
	 */
	public Date getSStime() {
		return sStime;
	}
	/**
	 * 设置：阶段结束时间
	 */
	public void setSEtime(Date sEtime) {
		this.sEtime = sEtime;
	}
	/**
	 * 获取：阶段结束时间
	 */
	public Date getSEtime() {
		return sEtime;
	}
	/**
	 * 设置：阶段完成进度 (1-100)
	 */
	public void setSProgress(Integer sProgress) {
		this.sProgress = sProgress;
	}
	/**
	 * 获取：阶段完成进度 (1-100)
	 */
	public Integer getSProgress() {
		return sProgress;
	}
	/**
	 * 设置：阶段菜单唯一编码
	 */
	public void setSMcode(Integer sMcode) {
		this.sMcode = sMcode;
	}
	/**
	 * 获取：阶段菜单唯一编码
	 */
	public Integer getSMcode() {
		return sMcode;
	}
	/**
	 * 设置：阶段管理人员说明
	 */
	public void setSManager(String sManager) {
		this.sManager = sManager;
	}
	/**
	 * 获取：阶段管理人员说明
	 */
	public String getSManager() {
		return sManager;
	}
}

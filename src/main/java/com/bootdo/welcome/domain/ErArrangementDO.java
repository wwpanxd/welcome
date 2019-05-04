package com.bootdo.welcome.domain;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * 考场分配表
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-05-03 16:17:01
 */
@ApiModel(value = "ErArrangementDO", description = "考场分配表") 
public class ErArrangementDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增主键
	@ApiModelProperty(value = "自增主键")
	private Long id;
	//学校唯一编码
	@ApiModelProperty(value = "学校唯一编码")
	private Integer uvCode;
	//学生唯一编码
	@ApiModelProperty(value = "学生唯一编码")
	private String sCode;
	//学生姓名
	@ApiModelProperty(value = "学生姓名")
	private String sName;
	//性别(0:未知,1:男,2:女)
	@ApiModelProperty(value = "性别(0:未知,1:男,2:女)")
	private Integer sSex;
	//临时考号
	@ApiModelProperty(value = "临时考号")
	private String sExCode;
	//考场编号
	@ApiModelProperty(value = "考场编号")
	private String rCode;
	//考场ID
	@ApiModelProperty(value = "考场ID")
	private Long rId;

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
	 * 设置：学生姓名
	 */
	public void setSName(String sName) {
		this.sName = sName;
	}
	/**
	 * 获取：学生姓名
	 */
	public String getSName() {
		return sName;
	}
	/**
	 * 设置：性别(0:未知,1:男,2:女)
	 */
	public void setSSex(Integer sSex) {
		this.sSex = sSex;
	}
	/**
	 * 获取：性别(0:未知,1:男,2:女)
	 */
	public Integer getSSex() {
		return sSex;
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
	/**
	 * 设置：考场编号
	 */
	public void setRCode(String rCode) {
		this.rCode = rCode;
	}
	/**
	 * 获取：考场编号
	 */
	public String getRCode() {
		return rCode;
	}
	/**
	 * 设置：考场ID
	 */
	public void setRId(Long rId) {
		this.rId = rId;
	}
	/**
	 * 获取：考场ID
	 */
	public Long getRId() {
		return rId;
	}
}

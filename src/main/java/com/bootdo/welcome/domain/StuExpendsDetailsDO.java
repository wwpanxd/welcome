package com.bootdo.welcome.domain;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 新生缴费明细表
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:56:29
 */
@ApiModel(value = "StuExpendsDetailsDO", description = "新生缴费明细表") 
public class StuExpendsDetailsDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	@ApiModelProperty(value = "")
	private Long id;
	//学校唯一编码
	@ApiModelProperty(value = "学校唯一编码")
	private Integer uvCode;
	//学生唯一编码
	@ApiModelProperty(value = "学生唯一编码")
	private String sCode;
	//缴费项编码
	@ApiModelProperty(value = "缴费项编码")
	private String subCode;
	//缴费金额
	@ApiModelProperty(value = "缴费金额")
	private Float subCost;
	//应该缴费金额
	@ApiModelProperty(value = "应该缴费金额")
	private Float epdYj;
	//缴费项
	@ApiModelProperty(value = "缴费项")
	private String subName;
	//缴费时间
	@ApiModelProperty(value = "缴费时间")
	private Long ptime;

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
	 * 设置：缴费项编码
	 */
	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}
	/**
	 * 获取：缴费项编码
	 */
	public String getSubCode() {
		return subCode;
	}
	/**
	 * 设置：缴费金额
	 */
	public void setSubCost(Float subCost) {
		this.subCost = subCost;
	}
	/**
	 * 获取：缴费金额
	 */
	public Float getSubCost() {
		return subCost;
	}
	/**
	 * 设置：应该缴费金额
	 */
	public void setEpdYj(Float epdYj) {
		this.epdYj = epdYj;
	}
	/**
	 * 获取：应该缴费金额
	 */
	public Float getEpdYj() {
		return epdYj;
	}
	/**
	 * 设置：缴费项
	 */
	public void setSubName(String subName) {
		this.subName = subName;
	}
	/**
	 * 获取：缴费项
	 */
	public String getSubName() {
		return subName;
	}
	/**
	 * 设置：缴费时间
	 */
	public void setPtime(Long ptime) {
		this.ptime = ptime;
	}
	/**
	 * 获取：缴费时间
	 */
	public Long getPtime() {
		return ptime;
	}
}

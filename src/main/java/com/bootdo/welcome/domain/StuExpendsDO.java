package com.bootdo.welcome.domain;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 新生缴费信息表
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:56:29
 */
@ApiModel(value = "StuExpendsDO", description = "新生缴费信息表") 
public class StuExpendsDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	@ApiModelProperty(value = "")
	private Long id;
	//学生唯一编码
	@ApiModelProperty(value = "学生唯一编码")
	private String sCode;
	//学校唯一编码
	@ApiModelProperty(value = "学校唯一编码")
	private Integer uvCode;
	//应该缴费金额
	@ApiModelProperty(value = "应该缴费金额")
	private Float epdYj;
	//已缴费金额
	@ApiModelProperty(value = "已缴费金额")
	private Float epdSj;
	//贷款费用
	@ApiModelProperty(value = "贷款费用")
	private Float epdDk;
	//减免费用
	@ApiModelProperty(value = "减免费用")
	private Float epdJm;
	//缴费状态(字典,0:未缴费,1:已缴费,2:部分缴费)
	@ApiModelProperty(value = "缴费状态(字典,0:未缴费,1:已缴费,2:部分缴费)")
	private Integer epdStatus;

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
	 * 设置：已缴费金额
	 */
	public void setEpdSj(Float epdSj) {
		this.epdSj = epdSj;
	}
	/**
	 * 获取：已缴费金额
	 */
	public Float getEpdSj() {
		return epdSj;
	}
	/**
	 * 设置：贷款费用
	 */
	public void setEpdDk(Float epdDk) {
		this.epdDk = epdDk;
	}
	/**
	 * 获取：贷款费用
	 */
	public Float getEpdDk() {
		return epdDk;
	}
	/**
	 * 设置：减免费用
	 */
	public void setEpdJm(Float epdJm) {
		this.epdJm = epdJm;
	}
	/**
	 * 获取：减免费用
	 */
	public Float getEpdJm() {
		return epdJm;
	}
	/**
	 * 设置：缴费状态(字典,0:未缴费,1:已缴费,2:部分缴费)
	 */
	public void setEpdStatus(Integer epdStatus) {
		this.epdStatus = epdStatus;
	}
	/**
	 * 获取：缴费状态(字典,0:未缴费,1:已缴费,2:部分缴费)
	 */
	public Integer getEpdStatus() {
		return epdStatus;
	}
}

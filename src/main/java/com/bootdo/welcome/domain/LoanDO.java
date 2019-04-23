package com.bootdo.welcome.domain;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 新生贷款表
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:55:53
 */
@ApiModel(value = "LoanDO", description = "新生贷款表") 
public class LoanDO implements Serializable {
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
	//贷款金额
	@ApiModelProperty(value = "贷款金额")
	private Float lCost;
	//是否办理(0:未办理,1:已办理)
	@ApiModelProperty(value = "是否办理(0:未办理,1:已办理)")
	private String lStatus;

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
	 * 设置：贷款金额
	 */
	public void setLCost(Float lCost) {
		this.lCost = lCost;
	}
	/**
	 * 获取：贷款金额
	 */
	public Float getLCost() {
		return lCost;
	}
	/**
	 * 设置：是否办理(0:未办理,1:已办理)
	 */
	public void setLStatus(String lStatus) {
		this.lStatus = lStatus;
	}
	/**
	 * 获取：是否办理(0:未办理,1:已办理)
	 */
	public String getLStatus() {
		return lStatus;
	}
}

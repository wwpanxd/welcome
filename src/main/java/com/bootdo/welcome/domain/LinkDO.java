package com.bootdo.welcome.domain;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 迎新环节表
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:55:53
 */
@ApiModel(value = "LinkDO", description = "迎新环节表") 
public class LinkDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	@ApiModelProperty(value = "")
	private Long id;
	//学校唯一编码(100000:公共机构)
	@ApiModelProperty(value = "学校唯一编码(100000:公共机构)")
	private Integer uvCode;
	//环节名称
	@ApiModelProperty(value = "环节名称")
	private String lkName;
	//环节说明描述
	@ApiModelProperty(value = "环节说明描述")
	private String lkDescription;
	//环节唯一编码
	@ApiModelProperty(value = "环节唯一编码")
	private Integer lkCode;

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
	 * 设置：学校唯一编码(100000:公共机构)
	 */
	public void setUvCode(Integer uvCode) {
		this.uvCode = uvCode;
	}
	/**
	 * 获取：学校唯一编码(100000:公共机构)
	 */
	public Integer getUvCode() {
		return uvCode;
	}
	/**
	 * 设置：环节名称
	 */
	public void setLkName(String lkName) {
		this.lkName = lkName;
	}
	/**
	 * 获取：环节名称
	 */
	public String getLkName() {
		return lkName;
	}
	/**
	 * 设置：环节说明描述
	 */
	public void setLkDescription(String lkDescription) {
		this.lkDescription = lkDescription;
	}
	/**
	 * 获取：环节说明描述
	 */
	public String getLkDescription() {
		return lkDescription;
	}
	/**
	 * 设置：环节唯一编码
	 */
	public void setLkCode(Integer lkCode) {
		this.lkCode = lkCode;
	}
	/**
	 * 获取：环节唯一编码
	 */
	public Integer getLkCode() {
		return lkCode;
	}
}

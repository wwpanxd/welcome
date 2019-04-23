package com.bootdo.welcome.domain;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 迎新通道表
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:54:52
 */
@ApiModel(value = "ChannelDO", description = "迎新通道表") 
public class ChannelDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	@ApiModelProperty(value = "")
	private Long id;
	//学校唯一编码
	@ApiModelProperty(value = "学校唯一编码")
	private Integer uvCode;
	//通道名称
	@ApiModelProperty(value = "通道名称")
	private String chName;
	//通道描述
	@ApiModelProperty(value = "通道描述")
	private String chDescription;
	//通道类型
	@ApiModelProperty(value = "通道类型")
	private Integer chType;

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
	 * 设置：通道名称
	 */
	public void setChName(String chName) {
		this.chName = chName;
	}
	/**
	 * 获取：通道名称
	 */
	public String getChName() {
		return chName;
	}
	/**
	 * 设置：通道描述
	 */
	public void setChDescription(String chDescription) {
		this.chDescription = chDescription;
	}
	/**
	 * 获取：通道描述
	 */
	public String getChDescription() {
		return chDescription;
	}
	/**
	 * 设置：通道类型
	 */
	public void setChType(Integer chType) {
		this.chType = chType;
	}
	/**
	 * 获取：通道类型
	 */
	public Integer getChType() {
		return chType;
	}
}

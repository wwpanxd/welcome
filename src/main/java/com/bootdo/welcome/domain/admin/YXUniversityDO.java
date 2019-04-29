package com.bootdo.welcome.domain.admin;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 迎新学校基础信息表
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:56:29
 */
@ApiModel(value = "YXUniversityDO", description = "迎新学校基础信息表") 
public class YXUniversityDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增主键
	@ApiModelProperty(value = "自增主键")
	private Long id;
	//学校唯一编码
	@ApiModelProperty(value = "学校唯一编码")
	private Integer uvCode;
	//学校名称
	@ApiModelProperty(value = "学校名称")
	private String uvName;
	//学校简称
	@ApiModelProperty(value = "学校简称")
	private String uvSname;
	//学校介绍
	@ApiModelProperty(value = "学校介绍")
	private String uvDescription;

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
	 * 设置：学校名称
	 */
	public void setUvName(String uvName) {
		this.uvName = uvName;
	}
	/**
	 * 获取：学校名称
	 */
	public String getUvName() {
		return uvName;
	}
	/**
	 * 设置：学校简称
	 */
	public void setUvSname(String uvSname) {
		this.uvSname = uvSname;
	}
	/**
	 * 获取：学校简称
	 */
	public String getUvSname() {
		return uvSname;
	}
	/**
	 * 设置：学校介绍
	 */
	public void setUvDescription(String uvDescription) {
		this.uvDescription = uvDescription;
	}
	/**
	 * 获取：学校介绍
	 */
	public String getUvDescription() {
		return uvDescription;
	}
}

package com.bootdo.welcome.domain;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 学生宿舍对应表
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:56:29
 */
@ApiModel(value = "StuDormitoryDO", description = "学生宿舍对应表") 
public class StuDormitoryDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	@ApiModelProperty(value = "")
	private Long id;
	//学校的唯一编码
	@ApiModelProperty(value = "学校的唯一编码")
	private Integer uvCode;
	//学生ID
	@ApiModelProperty(value = "学生ID")
	private Integer sId;
	//宿舍ID
	@ApiModelProperty(value = "宿舍ID")
	private Integer bId;
	//建筑级别
	@ApiModelProperty(value = "建筑级别")
	private Integer bLevel;

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
	public void setUvCode(Integer uvCode) {
		this.uvCode = uvCode;
	}
	/**
	 * 获取：学校的唯一编码
	 */
	public Integer getUvCode() {
		return uvCode;
	}
	/**
	 * 设置：学生ID
	 */
	public void setSId(Integer sId) {
		this.sId = sId;
	}
	/**
	 * 获取：学生ID
	 */
	public Integer getSId() {
		return sId;
	}
	/**
	 * 设置：宿舍ID
	 */
	public void setBId(Integer bId) {
		this.bId = bId;
	}
	/**
	 * 获取：宿舍ID
	 */
	public Integer getBId() {
		return bId;
	}
	/**
	 * 设置：建筑级别
	 */
	public void setBLevel(Integer bLevel) {
		this.bLevel = bLevel;
	}
	/**
	 * 获取：建筑级别
	 */
	public Integer getBLevel() {
		return bLevel;
	}
}

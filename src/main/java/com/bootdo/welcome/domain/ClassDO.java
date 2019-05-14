package com.bootdo.welcome.domain;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * 班级表
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-05-14 13:42:58
 */
@ApiModel(value = "ClassDO", description = "班级表") 
public class ClassDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	@ApiModelProperty(value = "")
	private Long id;
	//学校唯一编码(100000:公共机构)
	@ApiModelProperty(value = "学校唯一编码(100000:公共机构)")
	private Integer uvCode;
	//班级名称
	@ApiModelProperty(value = "班级名称")
	private String clName;
	//归属专业
	@ApiModelProperty(value = "归属专业")
	private Integer clZy;
	//归属学院
	@ApiModelProperty(value = "归属学院")
	private Integer clYx;
	//归属校区
	@ApiModelProperty(value = "归属校区")
	private Integer clXq;
	//归属教育阶段
	@ApiModelProperty(value = "归属教育阶段")
	private Integer clNj;
	//班主任ID
	@ApiModelProperty(value = "班主任ID")
	private Integer uId;
	//班号
	@ApiModelProperty(value = "班号")
	private String clCode;
	//院系表班级的ID
	@ApiModelProperty(value = "院系表班级的ID")
	private Long colId;

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
	 * 设置：班级名称
	 */
	public void setClName(String clName) {
		this.clName = clName;
	}
	/**
	 * 获取：班级名称
	 */
	public String getClName() {
		return clName;
	}
	/**
	 * 设置：归属专业
	 */
	public void setClZy(Integer clZy) {
		this.clZy = clZy;
	}
	/**
	 * 获取：归属专业
	 */
	public Integer getClZy() {
		return clZy;
	}
	/**
	 * 设置：归属学院
	 */
	public void setClYx(Integer clYx) {
		this.clYx = clYx;
	}
	/**
	 * 获取：归属学院
	 */
	public Integer getClYx() {
		return clYx;
	}
	/**
	 * 设置：归属校区
	 */
	public void setClXq(Integer clXq) {
		this.clXq = clXq;
	}
	/**
	 * 获取：归属校区
	 */
	public Integer getClXq() {
		return clXq;
	}
	/**
	 * 设置：归属教育阶段
	 */
	public void setClNj(Integer clNj) {
		this.clNj = clNj;
	}
	/**
	 * 获取：归属教育阶段
	 */
	public Integer getClNj() {
		return clNj;
	}
	/**
	 * 设置：班主任ID
	 */
	public void setUId(Integer uId) {
		this.uId = uId;
	}
	/**
	 * 获取：班主任ID
	 */
	public Integer getUId() {
		return uId;
	}
	/**
	 * 设置：班号
	 */
	public void setClCode(String clCode) {
		this.clCode = clCode;
	}
	/**
	 * 获取：班号
	 */
	public String getClCode() {
		return clCode;
	}
	/**
	 * 设置：院系表班级的ID
	 */
	public void setColId(Long colId) {
		this.colId = colId;
	}
	/**
	 * 获取：院系表班级的ID
	 */
	public Long getColId() {
		return colId;
	}
}

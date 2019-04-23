package com.bootdo.welcome.domain;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 学生和院系机构的关联表
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:56:29
 */
@ApiModel(value = "StuCollegeDO", description = "学生和院系机构的关联表") 
public class StuCollegeDO implements Serializable {
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
	//院系机构ID
	@ApiModelProperty(value = "院系机构ID")
	private Integer cId;
	//院系级别
	@ApiModelProperty(value = "院系级别")
	private Integer cLevel;
	//新生归属校区ID
	@ApiModelProperty(value = "新生归属校区ID")
	private Integer cXq;
	//新生归属院系ID
	@ApiModelProperty(value = "新生归属院系ID")
	private Integer cYx;
	//归属专业ID
	@ApiModelProperty(value = "归属专业ID")
	private Integer cZy;
	//归属班级ID
	@ApiModelProperty(value = "归属班级ID")
	private Integer cClass;

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
	 * 设置：院系机构ID
	 */
	public void setCId(Integer cId) {
		this.cId = cId;
	}
	/**
	 * 获取：院系机构ID
	 */
	public Integer getCId() {
		return cId;
	}
	/**
	 * 设置：院系级别
	 */
	public void setCLevel(Integer cLevel) {
		this.cLevel = cLevel;
	}
	/**
	 * 获取：院系级别
	 */
	public Integer getCLevel() {
		return cLevel;
	}
	/**
	 * 设置：新生归属校区ID
	 */
	public void setCXq(Integer cXq) {
		this.cXq = cXq;
	}
	/**
	 * 获取：新生归属校区ID
	 */
	public Integer getCXq() {
		return cXq;
	}
	/**
	 * 设置：新生归属院系ID
	 */
	public void setCYx(Integer cYx) {
		this.cYx = cYx;
	}
	/**
	 * 获取：新生归属院系ID
	 */
	public Integer getCYx() {
		return cYx;
	}
	/**
	 * 设置：归属专业ID
	 */
	public void setCZy(Integer cZy) {
		this.cZy = cZy;
	}
	/**
	 * 获取：归属专业ID
	 */
	public Integer getCZy() {
		return cZy;
	}
	/**
	 * 设置：归属班级ID
	 */
	public void setCClass(Integer cClass) {
		this.cClass = cClass;
	}
	/**
	 * 获取：归属班级ID
	 */
	public Integer getCClass() {
		return cClass;
	}
}

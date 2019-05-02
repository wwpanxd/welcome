package com.bootdo.welcome.domain;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 学校院系机构
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:54:52
 */
@ApiModel(value = "CollegeDO", description = "学校院系机构") 
public class CollegeDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "")
	private Long id;
	//学校唯一编码(100000:公共机构)
	@ApiModelProperty(value = "学校唯一编码(100000:公共机构)")
	private Integer uvCode;
	//院系级别
	@ApiModelProperty(value = "院系级别")
	private Integer cLevel;
	//上级部门ID，一级部门为0
	@ApiModelProperty(value = "上级部门ID，一级部门为0")
	private Long parentId;
	//院系名称
	@ApiModelProperty(value = "院系名称")
	private String cName;
	//排序
	@ApiModelProperty(value = "排序")
	private Integer cOrder;
	//状态  1：启用  0：禁用
	@ApiModelProperty(value = "状态  1：启用  0：禁用")
	private Integer cFlag;
	//专业编号
	@ApiModelProperty(value = "专业编号")
	private String cCode;

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
	 * 设置：上级部门ID，一级部门为0
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：上级部门ID，一级部门为0
	 */
	public Long getParentId() {
		return parentId;
	}
	/**
	 * 设置：院系名称
	 */
	public void setCName(String cName) {
		this.cName = cName;
	}
	/**
	 * 获取：院系名称
	 */
	public String getCName() {
		return cName;
	}
	/**
	 * 设置：排序
	 */
	public void setCOrder(Integer cOrder) {
		this.cOrder = cOrder;
	}
	/**
	 * 获取：排序
	 */
	public Integer getCOrder() {
		return cOrder;
	}
	/**
	 * 设置：状态  1：启用  0：禁用
	 */
	public void setCFlag(Integer cFlag) {
		this.cFlag = cFlag;
	}
	/**
	 * 获取：状态  1：启用  0：禁用
	 */
	public Integer getCFlag() {
		return cFlag;
	}
	/**
	 * 设置：专业编号
	 */
	public void setCCode(String cCode) {
		this.cCode = cCode;
	}
	/**
	 * 获取：专业编号
	 */
	public String getCCode() {
		return cCode;
	}
}

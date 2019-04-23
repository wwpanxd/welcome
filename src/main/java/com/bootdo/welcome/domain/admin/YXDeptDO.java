package com.bootdo.welcome.domain.admin;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:54:52
 */
@ApiModel(value = "DeptDO", description = "") 
public class YXDeptDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	@ApiModelProperty(value = "")
	private Long id;
	//学校的唯一编码
	@ApiModelProperty(value = "学校的唯一编码")
	private Integer uvCode;
	//父ID
	@ApiModelProperty(value = "父ID")
	private Long parentId;
	//部门名称
	@ApiModelProperty(value = "部门名称")
	private String dName;
	//排序
	@ApiModelProperty(value = "排序")
	private Integer dOrder;
	//是否启用
	@ApiModelProperty(value = "是否启用")
	private Integer dFlag;

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
	 * 设置：父ID
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：父ID
	 */
	public Long getParentId() {
		return parentId;
	}
	/**
	 * 设置：部门名称
	 */
	public void setDName(String dName) {
		this.dName = dName;
	}
	/**
	 * 获取：部门名称
	 */
	public String getDName() {
		return dName;
	}
	/**
	 * 设置：排序
	 */
	public void setDOrder(Integer dOrder) {
		this.dOrder = dOrder;
	}
	/**
	 * 获取：排序
	 */
	public Integer getDOrder() {
		return dOrder;
	}
	/**
	 * 设置：是否启用
	 */
	public void setDFlag(Integer dFlag) {
		this.dFlag = dFlag;
	}
	/**
	 * 获取：是否启用
	 */
	public Integer getDFlag() {
		return dFlag;
	}
}

package com.bootdo.welcome.domain;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 缴费科目表
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:55:53
 */
@ApiModel(value = "ExpendsSubjectsDO", description = "缴费科目表") 
public class ExpendsSubjectsDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	@ApiModelProperty(value = "")
	private Long id;
	//学校唯一编码
	@ApiModelProperty(value = "学校唯一编码")
	private Integer uvCode;
	//缴费项
	@ApiModelProperty(value = "缴费项")
	private String subName;
	//缴费项说明
	@ApiModelProperty(value = "缴费项说明")
	private String subDescription;
	//缴费项编码
	@ApiModelProperty(value = "缴费项编码")
	private String subCode;
	//专业编号
	@ApiModelProperty(value = "专业编号")
	private String clZy;
	//缴费金额
	@ApiModelProperty(value = "缴费金额")
	private Float subCost;
	//是否必缴(0:否,1:是)
	@ApiModelProperty(value = "是否必缴(0:否,1:是)")
	private Integer subFlag;
	//是否启用(字典)
	@ApiModelProperty(value = "是否启用(字典)")
	private Integer delFlag;

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
	 * 设置：缴费项
	 */
	public void setSubName(String subName) {
		this.subName = subName;
	}
	/**
	 * 获取：缴费项
	 */
	public String getSubName() {
		return subName;
	}
	/**
	 * 设置：缴费项说明
	 */
	public void setSubDescription(String subDescription) {
		this.subDescription = subDescription;
	}
	/**
	 * 获取：缴费项说明
	 */
	public String getSubDescription() {
		return subDescription;
	}
	/**
	 * 设置：缴费项编码
	 */
	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}
	/**
	 * 获取：缴费项编码
	 */
	public String getSubCode() {
		return subCode;
	}
	/**
	 * 设置：专业编号
	 */
	public void setClZy(String clZy) {
		this.clZy = clZy;
	}
	/**
	 * 获取：专业编号
	 */
	public String getClZy() {
		return clZy;
	}
	/**
	 * 设置：缴费金额
	 */
	public void setSubCost(Float subCost) {
		this.subCost = subCost;
	}
	/**
	 * 获取：缴费金额
	 */
	public Float getSubCost() {
		return subCost;
	}
	/**
	 * 设置：是否必缴(0:否,1:是)
	 */
	public void setSubFlag(Integer subFlag) {
		this.subFlag = subFlag;
	}
	/**
	 * 获取：是否必缴(0:否,1:是)
	 */
	public Integer getSubFlag() {
		return subFlag;
	}
	/**
	 * 设置：是否启用(字典)
	 */
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
	/**
	 * 获取：是否启用(字典)
	 */
	public Integer getDelFlag() {
		return delFlag;
	}
}

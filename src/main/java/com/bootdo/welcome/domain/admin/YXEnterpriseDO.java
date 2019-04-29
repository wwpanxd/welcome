package com.bootdo.welcome.domain.admin;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * 注册企业学校表
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-23 13:25:56
 */
@ApiModel(value = "YXEnterpriseDO", description = "注册企业学校表") 
public class YXEnterpriseDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增主键
	@ApiModelProperty(value = "自增主键")
	private Long uvId;
	//学校唯一编码,6~8位随机数
	@ApiModelProperty(value = "学校唯一编码,6~8位随机数")
	private Integer uvCode;
	//学校名称
	@ApiModelProperty(value = "学校名称")
	private String uvName;
	//学校简称
	@ApiModelProperty(value = "学校简称")
	private String uvSname;
	//归属省市县区
	@ApiModelProperty(value = "归属省市县区")
	private String uvCity;
	//学校类型(0:高职,1:普教)
	@ApiModelProperty(value = "学校类型(0:高职,1:普教)")
	private Integer uvType;
	//启用状态(1:启用,0:禁用)
	@ApiModelProperty(value = "启用状态(1:启用,0:禁用)")
	private Integer uvFlag;
	//负责人员
	@ApiModelProperty(value = "负责人员")
	private String uvManage;
	//负责人电话
	@ApiModelProperty(value = "负责人电话")
	private String uvPhone;

	/**
	 * 设置：自增主键
	 */
	public void setUvId(Long uvId) {
		this.uvId = uvId;
	}
	/**
	 * 获取：自增主键
	 */
	public Long getUvId() {
		return uvId;
	}
	/**
	 * 设置：学校唯一编码,6~8位随机数
	 */
	public void setUvCode(Integer uvCode) {
		this.uvCode = uvCode;
	}
	/**
	 * 获取：学校唯一编码,6~8位随机数
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
	 * 设置：归属省市县区
	 */
	public void setUvCity(String uvCity) {
		this.uvCity = uvCity;
	}
	/**
	 * 获取：归属省市县区
	 */
	public String getUvCity() {
		return uvCity;
	}
	/**
	 * 设置：学校类型(0:高职,1:普教)
	 */
	public void setUvType(Integer uvType) {
		this.uvType = uvType;
	}
	/**
	 * 获取：学校类型(0:高职,1:普教)
	 */
	public Integer getUvType() {
		return uvType;
	}
	/**
	 * 设置：启用状态(1:启用,0:禁用)
	 */
	public void setUvFlag(Integer uvFlag) {
		this.uvFlag = uvFlag;
	}
	/**
	 * 获取：启用状态(1:启用,0:禁用)
	 */
	public Integer getUvFlag() {
		return uvFlag;
	}
	/**
	 * 设置：负责人员
	 */
	public void setUvManage(String uvManage) {
		this.uvManage = uvManage;
	}
	/**
	 * 获取：负责人员
	 */
	public String getUvManage() {
		return uvManage;
	}
	/**
	 * 设置：负责人电话
	 */
	public void setUvPhone(String uvPhone) {
		this.uvPhone = uvPhone;
	}
	/**
	 * 获取：负责人电话
	 */
	public String getUvPhone() {
		return uvPhone;
	}
}

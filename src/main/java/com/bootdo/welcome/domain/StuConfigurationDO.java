package com.bootdo.welcome.domain;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * 新生信息采集配置表
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-05-14 13:18:36
 */
@ApiModel(value = "StuConfigurationDO", description = "新生信息采集配置表") 
public class StuConfigurationDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	@ApiModelProperty(value = "")
	private Long id;
	//学校唯一编码
	@ApiModelProperty(value = "学校唯一编码")
	private Integer uvCode;
	//采集项
	@ApiModelProperty(value = "采集项")
	private String cKey;
	//采集项代码
	@ApiModelProperty(value = "采集项代码")
	private String cValue;
	//采集项归属类别
	@ApiModelProperty(value = "采集项归属类别")
	private Integer cType;
	//显示排序
	@ApiModelProperty(value = "显示排序")
	private Integer cOrder;
	//是否采集
	@ApiModelProperty(value = "是否采集")
	private Integer cEnabled;
	//信息说明
	@ApiModelProperty(value = "信息说明")
	private String cDescription;
	//是否必选(0:非,1:必)
	@ApiModelProperty(value = "是否必选(0:非,1:必)")
	private Integer cMust;
	//字段类型(枚举字典)
	@ApiModelProperty(value = "字段类型(枚举字典)")
	private String cKind;
	//枚举编码
	@ApiModelProperty(value = "枚举编码")
	private String cDicCode;

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
	 * 设置：采集项
	 */
	public void setCKey(String cKey) {
		this.cKey = cKey;
	}
	/**
	 * 获取：采集项
	 */
	public String getCKey() {
		return cKey;
	}
	/**
	 * 设置：采集项代码
	 */
	public void setCValue(String cValue) {
		this.cValue = cValue;
	}
	/**
	 * 获取：采集项代码
	 */
	public String getCValue() {
		return cValue;
	}
	/**
	 * 设置：采集项归属类别
	 */
	public void setCType(Integer cType) {
		this.cType = cType;
	}
	/**
	 * 获取：采集项归属类别
	 */
	public Integer getCType() {
		return cType;
	}
	/**
	 * 设置：显示排序
	 */
	public void setCOrder(Integer cOrder) {
		this.cOrder = cOrder;
	}
	/**
	 * 获取：显示排序
	 */
	public Integer getCOrder() {
		return cOrder;
	}
	/**
	 * 设置：是否采集
	 */
	public void setCEnabled(Integer cEnabled) {
		this.cEnabled = cEnabled;
	}
	/**
	 * 获取：是否采集
	 */
	public Integer getCEnabled() {
		return cEnabled;
	}
	/**
	 * 设置：信息说明
	 */
	public void setCDescription(String cDescription) {
		this.cDescription = cDescription;
	}
	/**
	 * 获取：信息说明
	 */
	public String getCDescription() {
		return cDescription;
	}
	/**
	 * 设置：是否必选(0:非,1:必)
	 */
	public void setCMust(Integer cMust) {
		this.cMust = cMust;
	}
	/**
	 * 获取：是否必选(0:非,1:必)
	 */
	public Integer getCMust() {
		return cMust;
	}
	/**
	 * 设置：字段类型(枚举字典)
	 */
	public void setCKind(String cKind) {
		this.cKind = cKind;
	}
	/**
	 * 获取：字段类型(枚举字典)
	 */
	public String getCKind() {
		return cKind;
	}
	/**
	 * 设置：枚举编码
	 */
	public void setCDicCode(String cDicCode) {
		this.cDicCode = cDicCode;
	}
	/**
	 * 获取：枚举编码
	 */
	public String getCDicCode() {
		return cDicCode;
	}
}

package com.bootdo.welcome.domain;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 规则表(批量建班规则、分班规则、分宿规则、学号规则、考试分班规则)
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:56:29
 */
@ApiModel(value = "RuleDO", description = "规则表(批量建班规则、分班规则、分宿规则、学号规则、考试分班规则)") 
public class RuleDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增主键
	@ApiModelProperty(value = "自增主键")
	private Long id;
	//学校的唯一编码
	@ApiModelProperty(value = "学校的唯一编码")
	private Integer uvCode;
	//规则名称
	@ApiModelProperty(value = "规则名称")
	private String rName;
	//规则编码
	@ApiModelProperty(value = "规则编码")
	private Integer rCode;
	//规则类型(字典)
	@ApiModelProperty(value = "规则类型(字典)")
	private Integer rType;
	//规则描述
	@ApiModelProperty(value = "规则描述")
	private String rDescription;
	//是否启用
	@ApiModelProperty(value = "是否启用")
	private Integer rFlag;
	//规则字符字符串
	@ApiModelProperty(value = "规则字符字符串")
	private String rRule;

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
	 * 设置：规则名称
	 */
	public void setRName(String rName) {
		this.rName = rName;
	}
	/**
	 * 获取：规则名称
	 */
	public String getRName() {
		return rName;
	}
	/**
	 * 设置：规则编码
	 */
	public void setRCode(Integer rCode) {
		this.rCode = rCode;
	}
	/**
	 * 获取：规则编码
	 */
	public Integer getRCode() {
		return rCode;
	}
	/**
	 * 设置：规则类型(字典)
	 */
	public void setRType(Integer rType) {
		this.rType = rType;
	}
	/**
	 * 获取：规则类型(字典)
	 */
	public Integer getRType() {
		return rType;
	}
	/**
	 * 设置：规则描述
	 */
	public void setRDescription(String rDescription) {
		this.rDescription = rDescription;
	}
	/**
	 * 获取：规则描述
	 */
	public String getRDescription() {
		return rDescription;
	}
	/**
	 * 设置：是否启用
	 */
	public void setRFlag(Integer rFlag) {
		this.rFlag = rFlag;
	}
	/**
	 * 获取：是否启用
	 */
	public Integer getRFlag() {
		return rFlag;
	}
	/**
	 * 设置：规则字符字符串
	 */
	public void setRRule(String rRule) {
		this.rRule = rRule;
	}
	/**
	 * 获取：规则字符字符串
	 */
	public String getRRule() {
		return rRule;
	}
}

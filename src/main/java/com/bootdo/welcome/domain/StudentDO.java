package com.bootdo.welcome.domain;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 学生基础信息表
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:56:29
 */
@ApiModel(value = "StudentDO", description = "学生基础信息表") 
public class StudentDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增主键
	@ApiModelProperty(value = "自增主键")
	private Long id;
	//学校唯一编码(100000:公共机构)
//	@ApiModelProperty(value = "学校唯一编码(100000:公共机构)")
	@ApiModelProperty(value = "学校唯一编码")
	private Integer uvCode;
	//学生唯一编码
	@ApiModelProperty(value = "学生唯一编码")
	private String sCode;
	//学生姓名
	@ApiModelProperty(value = "学生姓名")
	private String sName;
	//性别(0:未知,1:男,2:女)
//	@ApiModelProperty(value = "性别(0:未知,1:男,2:女)")
	@ApiModelProperty(value = "性别")
	private Integer sSex;
	//身份证
	@ApiModelProperty(value = "身份证")
	private String sCard;
	//准考证号
	@ApiModelProperty(value = "准考证号")
	private String sExamNum;
	//考生号
	@ApiModelProperty(value = "考生号")
	private String sCandNum;
	//学号
	@ApiModelProperty(value = "学号")
	private String sAcadNum;
	//升学方式(字典定义803002)
//	@ApiModelProperty(value = "升学方式(字典定义803002)")
	@ApiModelProperty(value = "升学方式")
	private Integer sEnterType;

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
	 * 设置：学生唯一编码
	 */
	public void setSCode(String sCode) {
		this.sCode = sCode;
	}
	/**
	 * 获取：学生唯一编码
	 */
	public String getSCode() {
		return sCode;
	}
	/**
	 * 设置：学生姓名
	 */
	public void setSName(String sName) {
		this.sName = sName;
	}
	/**
	 * 获取：学生姓名
	 */
	public String getSName() {
		return sName;
	}
	/**
	 * 设置：性别(0:未知,1:男,2:女)
	 */
	public void setSSex(Integer sSex) {
		this.sSex = sSex;
	}
	/**
	 * 获取：性别(0:未知,1:男,2:女)
	 */
	public Integer getSSex() {
		return sSex;
	}
	/**
	 * 设置：身份证
	 */
	public void setSCard(String sCard) {
		this.sCard = sCard;
	}
	/**
	 * 获取：身份证
	 */
	public String getSCard() {
		return sCard;
	}
	/**
	 * 设置：准考证号
	 */
	public void setSExamNum(String sExamNum) {
		this.sExamNum = sExamNum;
	}
	/**
	 * 获取：准考证号
	 */
	public String getSExamNum() {
		return sExamNum;
	}
	/**
	 * 设置：考生号
	 */
	public void setSCandNum(String sCandNum) {
		this.sCandNum = sCandNum;
	}
	/**
	 * 获取：考生号
	 */
	public String getSCandNum() {
		return sCandNum;
	}
	/**
	 * 设置：学号
	 */
	public void setSAcadNum(String sAcadNum) {
		this.sAcadNum = sAcadNum;
	}
	/**
	 * 获取：学号
	 */
	public String getSAcadNum() {
		return sAcadNum;
	}
	/**
	 * 设置：升学方式(字典定义803002)
	 */
	public void setSEnterType(Integer sEnterType) {
		this.sEnterType = sEnterType;
	}
	/**
	 * 获取：升学方式(字典定义803002)
	 */
	public Integer getSEnterType() {
		return sEnterType;
	}
}

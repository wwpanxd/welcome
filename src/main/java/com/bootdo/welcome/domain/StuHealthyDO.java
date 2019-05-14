package com.bootdo.welcome.domain;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * 新生健康信息表
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-05-14 13:19:06
 */
@ApiModel(value = "StuHealthyDO", description = "新生健康信息表") 
public class StuHealthyDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	@ApiModelProperty(value = "")
	private Long id;
	//学校唯一编码
	@ApiModelProperty(value = "学校唯一编码")
	private Integer uvCode;
	//学生ID
	@ApiModelProperty(value = "学生ID")
	private Long sId;
	//家庭吸烟情况
	@ApiModelProperty(value = "家庭吸烟情况")
	private Integer sSmoking;
	//有无特定疾病
	@ApiModelProperty(value = "有无特定疾病")
	private String sDisease;
	//是否特异体质
	@ApiModelProperty(value = "是否特异体质")
	private String sPhysical;
	//进行剧烈运动时是否
	@ApiModelProperty(value = "进行剧烈运动时是否")
	private String sFaint;
	//家族遗传病史
	@ApiModelProperty(value = "家族遗传病史")
	private String sGenetic;
	//学生的目前情况及了解程度
	@ApiModelProperty(value = "学生的目前情况及了解程度")
	private String sStatus;
	//能否参加如下活动
	@ApiModelProperty(value = "能否参加如下活动")
	private String sSports;
	//疫苗接种情况次数
	@ApiModelProperty(value = "疫苗接种情况次数")
	private String sVaccine;
	//情况说明
	@ApiModelProperty(value = "情况说明")
	private String sMark;

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
	 * 设置：学生ID
	 */
	public void setSId(Long sId) {
		this.sId = sId;
	}
	/**
	 * 获取：学生ID
	 */
	public Long getSId() {
		return sId;
	}
	/**
	 * 设置：家庭吸烟情况
	 */
	public void setSSmoking(Integer sSmoking) {
		this.sSmoking = sSmoking;
	}
	/**
	 * 获取：家庭吸烟情况
	 */
	public Integer getSSmoking() {
		return sSmoking;
	}
	/**
	 * 设置：有无特定疾病
	 */
	public void setSDisease(String sDisease) {
		this.sDisease = sDisease;
	}
	/**
	 * 获取：有无特定疾病
	 */
	public String getSDisease() {
		return sDisease;
	}
	/**
	 * 设置：是否特异体质
	 */
	public void setSPhysical(String sPhysical) {
		this.sPhysical = sPhysical;
	}
	/**
	 * 获取：是否特异体质
	 */
	public String getSPhysical() {
		return sPhysical;
	}
	/**
	 * 设置：进行剧烈运动时是否
	 */
	public void setSFaint(String sFaint) {
		this.sFaint = sFaint;
	}
	/**
	 * 获取：进行剧烈运动时是否
	 */
	public String getSFaint() {
		return sFaint;
	}
	/**
	 * 设置：家族遗传病史
	 */
	public void setSGenetic(String sGenetic) {
		this.sGenetic = sGenetic;
	}
	/**
	 * 获取：家族遗传病史
	 */
	public String getSGenetic() {
		return sGenetic;
	}
	/**
	 * 设置：学生的目前情况及了解程度
	 */
	public void setSStatus(String sStatus) {
		this.sStatus = sStatus;
	}
	/**
	 * 获取：学生的目前情况及了解程度
	 */
	public String getSStatus() {
		return sStatus;
	}
	/**
	 * 设置：能否参加如下活动
	 */
	public void setSSports(String sSports) {
		this.sSports = sSports;
	}
	/**
	 * 获取：能否参加如下活动
	 */
	public String getSSports() {
		return sSports;
	}
	/**
	 * 设置：疫苗接种情况次数
	 */
	public void setSVaccine(String sVaccine) {
		this.sVaccine = sVaccine;
	}
	/**
	 * 获取：疫苗接种情况次数
	 */
	public String getSVaccine() {
		return sVaccine;
	}
	/**
	 * 设置：情况说明
	 */
	public void setSMark(String sMark) {
		this.sMark = sMark;
	}
	/**
	 * 获取：情况说明
	 */
	public String getSMark() {
		return sMark;
	}
}

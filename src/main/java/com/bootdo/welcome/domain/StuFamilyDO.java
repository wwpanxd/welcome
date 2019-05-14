package com.bootdo.welcome.domain;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * 新生家长信息表
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-05-14 13:18:57
 */
@ApiModel(value = "StuFamilyDO", description = "新生家长信息表") 
public class StuFamilyDO implements Serializable {
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
	//家庭关系-称谓
	@ApiModelProperty(value = "家庭关系-称谓")
	private String fRelationship;
	//姓名
	@ApiModelProperty(value = "姓名")
	private String fName;
	//政治面貌
	@ApiModelProperty(value = "政治面貌")
	private String fPolitical;
	//教育程度
	@ApiModelProperty(value = "教育程度")
	private String fEducation;
	//工作单位及职务
	@ApiModelProperty(value = "工作单位及职务")
	private String fJobDept;
	//年龄
	@ApiModelProperty(value = "年龄")
	private Integer fAge;
	//邮箱
	@ApiModelProperty(value = "邮箱")
	private String fEmail;
	//电话
	@ApiModelProperty(value = "电话")
	private String fPhone;
	//关系说明
	@ApiModelProperty(value = "关系说明")
	private String fRsRemark;
	//现住址
	@ApiModelProperty(value = "现住址")
	private String fAddress;
	//户口所在地行政区划
	@ApiModelProperty(value = "户口所在地行政区划")
	private String fArea;
	//民族
	@ApiModelProperty(value = "民族")
	private String fNation;
	//是否监护人
	@ApiModelProperty(value = "是否监护人")
	private Integer fGuardianship;
	//身份证号
	@ApiModelProperty(value = "身份证号")
	private String fCardno;

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
	 * 设置：家庭关系-称谓
	 */
	public void setFRelationship(String fRelationship) {
		this.fRelationship = fRelationship;
	}
	/**
	 * 获取：家庭关系-称谓
	 */
	public String getFRelationship() {
		return fRelationship;
	}
	/**
	 * 设置：姓名
	 */
	public void setFName(String fName) {
		this.fName = fName;
	}
	/**
	 * 获取：姓名
	 */
	public String getFName() {
		return fName;
	}
	/**
	 * 设置：政治面貌
	 */
	public void setFPolitical(String fPolitical) {
		this.fPolitical = fPolitical;
	}
	/**
	 * 获取：政治面貌
	 */
	public String getFPolitical() {
		return fPolitical;
	}
	/**
	 * 设置：教育程度
	 */
	public void setFEducation(String fEducation) {
		this.fEducation = fEducation;
	}
	/**
	 * 获取：教育程度
	 */
	public String getFEducation() {
		return fEducation;
	}
	/**
	 * 设置：工作单位及职务
	 */
	public void setFJobDept(String fJobDept) {
		this.fJobDept = fJobDept;
	}
	/**
	 * 获取：工作单位及职务
	 */
	public String getFJobDept() {
		return fJobDept;
	}
	/**
	 * 设置：年龄
	 */
	public void setFAge(Integer fAge) {
		this.fAge = fAge;
	}
	/**
	 * 获取：年龄
	 */
	public Integer getFAge() {
		return fAge;
	}
	/**
	 * 设置：邮箱
	 */
	public void setFEmail(String fEmail) {
		this.fEmail = fEmail;
	}
	/**
	 * 获取：邮箱
	 */
	public String getFEmail() {
		return fEmail;
	}
	/**
	 * 设置：电话
	 */
	public void setFPhone(String fPhone) {
		this.fPhone = fPhone;
	}
	/**
	 * 获取：电话
	 */
	public String getFPhone() {
		return fPhone;
	}
	/**
	 * 设置：关系说明
	 */
	public void setFRsRemark(String fRsRemark) {
		this.fRsRemark = fRsRemark;
	}
	/**
	 * 获取：关系说明
	 */
	public String getFRsRemark() {
		return fRsRemark;
	}
	/**
	 * 设置：现住址
	 */
	public void setFAddress(String fAddress) {
		this.fAddress = fAddress;
	}
	/**
	 * 获取：现住址
	 */
	public String getFAddress() {
		return fAddress;
	}
	/**
	 * 设置：户口所在地行政区划
	 */
	public void setFArea(String fArea) {
		this.fArea = fArea;
	}
	/**
	 * 获取：户口所在地行政区划
	 */
	public String getFArea() {
		return fArea;
	}
	/**
	 * 设置：民族
	 */
	public void setFNation(String fNation) {
		this.fNation = fNation;
	}
	/**
	 * 获取：民族
	 */
	public String getFNation() {
		return fNation;
	}
	/**
	 * 设置：是否监护人
	 */
	public void setFGuardianship(Integer fGuardianship) {
		this.fGuardianship = fGuardianship;
	}
	/**
	 * 获取：是否监护人
	 */
	public Integer getFGuardianship() {
		return fGuardianship;
	}
	/**
	 * 设置：身份证号
	 */
	public void setFCardno(String fCardno) {
		this.fCardno = fCardno;
	}
	/**
	 * 获取：身份证号
	 */
	public String getFCardno() {
		return fCardno;
	}
}

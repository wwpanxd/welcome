package com.bootdo.welcome.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "SchoolDistrictVO", description = "更新校区")
public class SchoolDistrictVO implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "学校名字")
	private String schoolName;
	@ApiModelProperty(value = "学校编码")
	private String schoolCode;
	@ApiModelProperty(value = "学校地址")
	private String schoolAddress;
	@ApiModelProperty(value = "学校联系方式")
	private String schoolPhone;

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolCode() {
		return schoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}

	public String getSchoolAddress() {
		return schoolAddress;
	}

	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}

	public String getSchoolPhone() {
		return schoolPhone;
	}

	public void setSchoolPhone(String schoolPhone) {
		this.schoolPhone = schoolPhone;
	}
}

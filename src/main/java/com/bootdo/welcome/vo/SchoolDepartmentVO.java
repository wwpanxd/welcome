package com.bootdo.welcome.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SchoolDepartmentVO", description = "新增院系")
public class SchoolDepartmentVO implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "学校编码")
	private String schoolCode;
	@ApiModelProperty(value = "院系名称")
	private String departmentName;
	@ApiModelProperty(value = "院系编码")
	private String departmentCode;
	@ApiModelProperty(value = "院系办公电话")
	private String departmentPhone;

	public String getSchoolCode() {
		return schoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentPhone() {
		return departmentPhone;
	}

	public void setDepartmentPhone(String departmentPhone) {
		this.departmentPhone = departmentPhone;
	}
}

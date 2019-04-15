package com.bootdo.welcome.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SchoolDepartmentDO", description = "院系")
public class SchoolDepartmentDO implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;
	@ApiModelProperty(value = "学校编码")
	private String schoolCode;
	@ApiModelProperty(value = "院系名称")
	private String departmentName;
	@ApiModelProperty(value = "院系编码")
	private String departmentCode;
	@ApiModelProperty(value = "院系办公电话")
	private String departmentPhone;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

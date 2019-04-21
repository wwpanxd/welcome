package com.bootdo.welcome.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="SchoolProfessionVO",description="新增专业")
public class SchoolProfessionVO implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "专业名称")
	private String professionName;
	public String getProfessionName() {
		return professionName;
	}
	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}
}

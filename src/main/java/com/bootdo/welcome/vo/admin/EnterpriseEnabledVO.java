package com.bootdo.welcome.vo.admin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="EnterpriseEnabledVO",description="企业学校启用禁用入参")
public class EnterpriseEnabledVO {

	@ApiModelProperty(value="企业学校ID")
	Long id;
	
	@ApiModelProperty(value="1:启用,0:禁用")
	Integer enable;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getEnable() {
		return enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}



}

package com.bootdo.welcome.vo.admin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="EnterpriseClearVO",description="学校数据清理入参")
public class EnterpriseClearVO {

	@ApiModelProperty(value="企业学校ID")
	Long id;
	
	@ApiModelProperty(value="清理数据的学校密码")
	String pwcode;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPwcode() {
		return pwcode;
	}

	public void setPwcode(String pwcode) {
		this.pwcode = pwcode;
	}

}

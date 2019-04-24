package com.bootdo.welcome.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class DeletedStringId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value="唯一编码")
	private String idString;

	public String getIdString() {
		return idString;
	}

	public void setIdString(String idString) {
		this.idString = idString;
	}
}

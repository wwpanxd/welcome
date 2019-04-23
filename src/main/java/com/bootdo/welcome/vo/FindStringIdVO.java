package com.bootdo.welcome.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "FindStringId", description = "查找数据时,使用的id,给get方法body使用")
public class FindStringIdVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}

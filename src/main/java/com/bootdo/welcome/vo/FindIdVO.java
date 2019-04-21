package com.bootdo.welcome.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "FindId", description = "查找数据时,使用的id,给get方法body使用")
public class FindIdVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}

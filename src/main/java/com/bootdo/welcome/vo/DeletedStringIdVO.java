package com.bootdo.welcome.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;

@ApiModel(value="DeletedId",description="单条删除时,使用的id,给post方法body使用")
public class DeletedStringIdVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}

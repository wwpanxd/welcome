package com.bootdo.welcome.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;

@ApiModel(value="DeletedId",description="单条删除时,使用的id,给post方法body使用")
public class DeletedIdVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}

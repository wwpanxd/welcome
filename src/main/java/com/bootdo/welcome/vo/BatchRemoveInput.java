package com.bootdo.welcome.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="BatchRemoveInput",description="批量删除的IDS")
public class BatchRemoveInput {

	@ApiModelProperty(value="批量删除IDS")
	Long[] ids;

	public Long[] getIds() {
		return ids;
	}

	public void setIds(Long[] ids) {
		this.ids = ids;
	}


}

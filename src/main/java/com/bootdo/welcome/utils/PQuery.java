package com.bootdo.welcome.utils;

import java.util.LinkedHashMap;
import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 查询参数
 */
@ApiModel(value="PQuery",description="分页查询类")
public class PQuery extends LinkedHashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value="当前页")
	private int page;
	// 每页条数
	 @ApiModelProperty(value="每页条数")
	private int size;

	public PQuery(Map<String, Object> params) {
		this.putAll(params);
		// 分页参数
		this.page = Integer.parseInt(params.get("page").toString());
		this.size = Integer.parseInt(params.get("size").toString());
		
		this.put("offset", ((this.page-1)<0?0:(this.page-1))*this.size);
		this.put("page", this.page);
		this.put("limit", size);
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}

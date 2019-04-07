package com.bootdo.welcome.utils;

import java.io.Serializable;
import java.util.List;

public class  PPageUtils implements Serializable {
	private static final long serialVersionUID = 1L;
	private int total;//数据总条数
	private List<?> rows;//数据
	private Integer page = 0;//当前页
	private Integer size = 8;//每页条数

	public PPageUtils(List<?> list, int total,int page,int size) {
		this.rows = list;
		this.total = total;
		this.page=page;
		this.size=size;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

}

package com.bootdo.welcome.utils;

/*
 * 普通的操作成功失败返回
 * */
public class PR {
private int code;
private String msg;

	public PR() {
		this.code=0;
		this.msg="操作成功";
	}

	public static PR error() {
		return error(1, "操作失败");
	}

	public static PR error(String msg) {
		return error(1, msg);
	}

	public static PR ok(String msg) {
		PR r = new PR();
		r.setCode(0);
		r.setMsg(msg);
		return r;
	}

	public static PR ok() {
		return new PR();
	}
	
	private static PR error(int code, String msg) {
		PR r = new PR();
		r.setCode(code);
		r.setMsg(msg);
		return r;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}

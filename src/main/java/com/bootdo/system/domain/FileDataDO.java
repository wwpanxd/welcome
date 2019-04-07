package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 文件数据表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-01-20 01:50:52
 */
public class FileDataDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//文件名，唯一
	private String fname;
	private String foname;
	//文件base64二进制
	private byte[] fdata;
	//文件类型
	private String ftype;
	//创建日期
	private Date ctime;
	//使用次数
	private Integer num;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：文件名，唯一
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}
	/**
	 * 获取：文件名，唯一
	 */
	public String getFname() {
		return fname;
	}

	/**
	 * 设置：文件类型
	 */
	public void setFtype(String ftype) {
		this.ftype = ftype;
	}
	/**
	 * 获取：文件类型
	 */
	public String getFtype() {
		return ftype;
	}
	/**
	 * 设置：创建日期
	 */
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	/**
	 * 获取：创建日期
	 */
	public Date getCtime() {
		return ctime;
	}
	/**
	 * 设置：使用次数
	 */
	public void setNum(Integer num) {
		this.num = num;
	}
	/**
	 * 获取：使用次数
	 */
	public Integer getNum() {
		return num;
	}
	public String getFoname() {
		return foname;
	}
	public void setFoname(String foname) {
		this.foname = foname;
	}
	public byte[] getFdata() {
		return fdata;
	}
	public void setFdata(byte[] fdata) {
		this.fdata = fdata;
	}
}

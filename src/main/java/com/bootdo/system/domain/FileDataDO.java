package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * 文件数据表
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:52:54
 */
@ApiModel(value = "FileDataDO", description = "文件数据表") 
public class FileDataDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	@ApiModelProperty(value = "")
	private Long id;
	//文件名，唯一
	@ApiModelProperty(value = "文件名，唯一")
	private String fname;
	//文件原始名称
	@ApiModelProperty(value = "文件原始名称")
	private String foname;
	//文件二进制
	@ApiModelProperty(value = "文件二进制")
	private byte[] fdata;
	//文件类型
	@ApiModelProperty(value = "文件类型")
	private String ftype;
	//创建日期
	@ApiModelProperty(value = "创建日期")
	private Date ctime;
	//使用次数
	@ApiModelProperty(value = "使用次数")
	private Integer num;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
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
	 * 设置：文件原始名称
	 */
	public void setFoname(String foname) {
		this.foname = foname;
	}
	/**
	 * 获取：文件原始名称
	 */
	public String getFoname() {
		return foname;
	}
	/**
	 * 设置：文件二进制
	 */
	public void setFdata(byte[] fdata) {
		this.fdata = fdata;
	}
	/**
	 * 获取：文件二进制
	 */
	public byte[] getFdata() {
		return fdata;
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
}

package com.bootdo.welcome.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 英语单词记录表
 * 
 */
@ApiModel(value="WordsDO",description="单词表")
public class WordsDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@ApiModelProperty(value="英文单词")
	private String ewords;
	//英文发音
	@ApiModelProperty(value="英文发音")
	private String swords;
	//中文单词
	@ApiModelProperty(value="中文单词")
	private String cwords;
	//归属类别，英语1-8级
	@ApiModelProperty(value="归属类别")
	private String tcode;
	@ApiModelProperty(value="添加时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date atime;
	
	@ApiModelProperty(value="查询开始时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date btime;
	
	@ApiModelProperty(value="查询结束时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date etime;

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
	 * 设置：英文单词
	 */
	public void setEwords(String ewords) {
		this.ewords = ewords;
	}
	/**
	 * 获取：英文单词
	 */
	public String getEwords() {
		return ewords;
	}
	/**
	 * 设置：英文发音
	 */
	public void setSwords(String swords) {
		this.swords = swords;
	}
	/**
	 * 获取：英文发音
	 */
	public String getSwords() {
		return swords;
	}
	/**
	 * 设置：中文单词
	 */
	public void setCwords(String cwords) {
		this.cwords = cwords;
	}
	/**
	 * 获取：中文单词
	 */
	public String getCwords() {
		return cwords;
	}
	/**
	 * 设置：归属类别，英语1-8级
	 */
	public void setTcode(String tcode) {
		this.tcode = tcode;
	}
	/**
	 * 获取：归属类别，英语1-8级
	 */
	public String getTcode() {
		return tcode;
	}
	public Date getAtime() {
		return atime;
	}
	public void setAtime(Date atime) {
		this.atime = atime;
	}
	public Date getBtime() {
		return btime;
	}
	public void setBtime(Date btime) {
		this.btime = btime;
	}
	public Date getEtime() {
		return etime;
	}
	public void setEtime(Date etime) {
		this.etime = etime;
	}
}

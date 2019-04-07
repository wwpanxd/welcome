package com.bootdo.welcome.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 单词版本更新表
 * 
 */
@ApiModel(value="WdverDO",description="单词库更新表")
public class WdverDO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	//版本号
	@ApiModelProperty(value="版本号")
	private Integer ver;
	//是否最新版本：1：是，0：否
	@ApiModelProperty(value="是否最新版本：1：是，0：否")
	private Integer islast;
	//单词归属类别（分库）
	@ApiModelProperty(value="单词归属类别")
	private String tcode;
	//更新说明
	@ApiModelProperty(value="更新说明")
	private String info;
	//更新时间
	@ApiModelProperty(value="更新时间")
	private Long utime;

	public WdverDO() {}
	
	public WdverDO(Integer ver, Integer islast, String tcode, String info, Long utime) {
		super();
		this.ver = ver;
		this.islast = islast;
		this.tcode = tcode;
		this.info = info;
		this.utime = utime;
	}
	
	
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
	 * 设置：版本号
	 */
	public void setVer(Integer ver) {
		this.ver = ver;
	}
	/**
	 * 获取：版本号
	 */
	public Integer getVer() {
		return ver;
	}
	/**
	 * 设置：是否最新版本：1：是，0：否
	 */
	public void setIslast(Integer islast) {
		this.islast = islast;
	}
	/**
	 * 获取：是否最新版本：1：是，0：否
	 */
	public Integer getIslast() {
		return islast;
	}
	/**
	 * 设置：单词归属类别（分库）
	 */
	public void setTcode(String tcode) {
		this.tcode = tcode;
	}
	/**
	 * 获取：单词归属类别（分库）
	 */
	public String getTcode() {
		return tcode;
	}
	/**
	 * 设置：更新说明
	 */
	public void setInfo(String info) {
		this.info = info;
	}
	/**
	 * 获取：更新说明
	 */
	public String getInfo() {
		return info;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUtime(Long utime) {
		this.utime = utime;
	}
	/**
	 * 获取：更新时间
	 */
	public Long getUtime() {
		return utime;
	}
}

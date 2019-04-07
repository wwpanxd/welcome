package com.bootdo.system.domain;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * app版本更新表
 * 
 */
@ApiModel(value="AppDO",description="App版本信息类")
public class AppDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@ApiModelProperty(value="版本号")
	private Integer ver;
	@ApiModelProperty(value="强制更新:0:不强制,1:强制")
	private Integer update;
	@ApiModelProperty(value="最新标注1:最新版本，0：历史版本")
	private Integer enable;
	@ApiModelProperty(value="下载url")
	private String url;
	@ApiModelProperty(value="版本更新说明")
	private String info;
	@ApiModelProperty(value="更新时间")
	private Long utime;

	public AppDO() {}
	
	public AppDO(Integer ver,Integer update, String url, String info, Long utime) {
		this.ver = ver;
		this.update=update;
		this.url = url;
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
	 * 设置：强制更新0:不强制,1:强制
	 */
	public void setUpdate(Integer update) {
		this.update = update;
	}
	/**
	 * 获取：强制更新0:不强制,1:强制
	 */
	public Integer getUpdate() {
		return update;
	}
	/**
	 * 设置：1:最新版本，0：历史版本
	 */
	public void setEnable(Integer enable) {
		this.enable = enable;
	}
	/**
	 * 获取：1:最新版本，0：历史版本
	 */
	public Integer getEnable() {
		return enable;
	}
	/**
	 * 设置：下载url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：下载url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：版本更新说明
	 */
	public void setInfo(String info) {
		this.info = info;
	}
	/**
	 * 获取：版本更新说明
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

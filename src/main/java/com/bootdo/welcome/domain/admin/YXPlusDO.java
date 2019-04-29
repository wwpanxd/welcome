package com.bootdo.welcome.domain.admin;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 插件信息表
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:52:54
 */
@ApiModel(value = "YXPlusDO", description = "插件信息表") 
public class YXPlusDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增主键
	@ApiModelProperty(value = "自增主键")
	private Long pId;
	//插件名称
	@ApiModelProperty(value = "插件名称")
	private String name;
	//插件url
	@ApiModelProperty(value = "插件url")
	private String url;
	//功能描述
	@ApiModelProperty(value = "功能描述")
	private String description;
	//插件唯一编码
	@ApiModelProperty(value = "插件唯一编码")
	private Integer code;
	//插件费用描述
	@ApiModelProperty(value = "插件费用描述")
	private String cost;
	//启用状态(1:启用,0:禁用)
	@ApiModelProperty(value = "启用状态(1:启用,0:禁用)")
	private Integer flag;

	/**
	 * 设置：自增主键
	 */
	public void setPId(Long pId) {
		this.pId = pId;
	}
	/**
	 * 获取：自增主键
	 */
	public Long getPId() {
		return pId;
	}
	/**
	 * 设置：插件名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：插件名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：插件url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：插件url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：功能描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：功能描述
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置：插件唯一编码
	 */
	public void setCode(Integer code) {
		this.code = code;
	}
	/**
	 * 获取：插件唯一编码
	 */
	public Integer getCode() {
		return code;
	}
	/**
	 * 设置：插件费用描述
	 */
	public void setCost(String cost) {
		this.cost = cost;
	}
	/**
	 * 获取：插件费用描述
	 */
	public String getCost() {
		return cost;
	}
	/**
	 * 设置：启用状态(1:启用,0:禁用)
	 */
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	/**
	 * 获取：启用状态(1:启用,0:禁用)
	 */
	public Integer getFlag() {
		return flag;
	}
}

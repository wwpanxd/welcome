package com.bootdo.welcome.domain.admin;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 菜单管理
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:55:53
 */
@ApiModel(value = "MenuDO", description = "菜单管理") 
public class YXMenuDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	@ApiModelProperty(value = "")
	private Long mid;
	//父菜单ID，一级菜单为0
	@ApiModelProperty(value = "父菜单ID，一级菜单为0")
	private Long parentId;
	//菜单名称
	@ApiModelProperty(value = "菜单名称")
	private String name;
	//菜单URL
	@ApiModelProperty(value = "菜单URL")
	private String url;
	//授权(多个用逗号分隔，如：user:list,user:create)
	@ApiModelProperty(value = "授权(多个用逗号分隔，如：user:list,user:create)")
	private String perms;
	//类型   0：目录   1：菜单   2：按钮
	@ApiModelProperty(value = "类型   0：目录   1：菜单   2：按钮")
	private Integer type;
	//菜单图标
	@ApiModelProperty(value = "菜单图标")
	private String icon;
	//排序
	@ApiModelProperty(value = "排序")
	private Integer orderNum;
	//学校唯一编码(100000:公共机构)
	@ApiModelProperty(value = "学校唯一编码(100000:公共机构)")
	private Integer uvCode;
	//插件菜单唯一编码
	@ApiModelProperty(value = "插件菜单唯一编码")
	private Integer mcode;

	/**
	 * 设置：
	 */
	public void setMid(Long mid) {
		this.mid = mid;
	}
	/**
	 * 获取：
	 */
	public Long getMid() {
		return mid;
	}
	/**
	 * 设置：父菜单ID，一级菜单为0
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：父菜单ID，一级菜单为0
	 */
	public Long getParentId() {
		return parentId;
	}
	/**
	 * 设置：菜单名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：菜单名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：菜单URL
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：菜单URL
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：授权(多个用逗号分隔，如：user:list,user:create)
	 */
	public void setPerms(String perms) {
		this.perms = perms;
	}
	/**
	 * 获取：授权(多个用逗号分隔，如：user:list,user:create)
	 */
	public String getPerms() {
		return perms;
	}
	/**
	 * 设置：类型   0：目录   1：菜单   2：按钮
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：类型   0：目录   1：菜单   2：按钮
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：菜单图标
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	/**
	 * 获取：菜单图标
	 */
	public String getIcon() {
		return icon;
	}
	/**
	 * 设置：排序
	 */
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	/**
	 * 获取：排序
	 */
	public Integer getOrderNum() {
		return orderNum;
	}
	/**
	 * 设置：学校唯一编码(100000:公共机构)
	 */
	public void setUvCode(Integer uvCode) {
		this.uvCode = uvCode;
	}
	/**
	 * 获取：学校唯一编码(100000:公共机构)
	 */
	public Integer getUvCode() {
		return uvCode;
	}
	/**
	 * 设置：插件菜单唯一编码
	 */
	public void setMcode(Integer mcode) {
		this.mcode = mcode;
	}
	/**
	 * 获取：插件菜单唯一编码
	 */
	public Integer getMcode() {
		return mcode;
	}
}

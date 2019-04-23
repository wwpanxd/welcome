package com.bootdo.welcome.domain.admin;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 用户与角色对应关系
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:57:11
 */
@ApiModel(value = "UserRoleDO", description = "用户与角色对应关系") 
public class YXUserRoleDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	@ApiModelProperty(value = "")
	private Long id;
	//用户ID
	@ApiModelProperty(value = "用户ID")
	private Long userId;
	//角色ID
	@ApiModelProperty(value = "角色ID")
	private Long roleId;
	//学校唯一编码(100000:公共机构)
	@ApiModelProperty(value = "学校唯一编码(100000:公共机构)")
	private Integer uvCode;

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
	 * 设置：用户ID
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户ID
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：角色ID
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	/**
	 * 获取：角色ID
	 */
	public Long getRoleId() {
		return roleId;
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
}

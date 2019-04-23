package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * 角色
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:52:54
 */
@ApiModel(value = "RoleDO", description = "角色") 
public class RoleDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	@ApiModelProperty(value = "")
	private Long roleId;
	//角色名称
	@ApiModelProperty(value = "角色名称")
	private String roleName;
	//角色标识
	@ApiModelProperty(value = "角色标识")
	private String roleSign;
	//备注
	@ApiModelProperty(value = "备注")
	private String remark;
	//创建用户id
	@ApiModelProperty(value = "创建用户id")
	private Long userIdCreate;
	//创建时间
	@ApiModelProperty(value = "创建时间")
	private Date gmtCreate;
	//创建时间
	@ApiModelProperty(value = "创建时间")
	private Date gmtModified;
	
	private List<Long> menuIds;

	/**
	 * 设置：
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	/**
	 * 获取：
	 */
	public Long getRoleId() {
		return roleId;
	}
	/**
	 * 设置：角色名称
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**
	 * 获取：角色名称
	 */
	public String getRoleName() {
		return roleName;
	}
	/**
	 * 设置：角色标识
	 */
	public void setRoleSign(String roleSign) {
		this.roleSign = roleSign;
	}
	/**
	 * 获取：角色标识
	 */
	public String getRoleSign() {
		return roleSign;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：创建用户id
	 */
	public void setUserIdCreate(Long userIdCreate) {
		this.userIdCreate = userIdCreate;
	}
	/**
	 * 获取：创建用户id
	 */
	public Long getUserIdCreate() {
		return userIdCreate;
	}
	/**
	 * 设置：创建时间
	 */
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getGmtCreate() {
		return gmtCreate;
	}
	/**
	 * 设置：创建时间
	 */
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getGmtModified() {
		return gmtModified;
	}
	public List<Long> getMenuIds() {
		return menuIds;
	}
	public void setMenuIds(List<Long> menuIds) {
		this.menuIds = menuIds;
	}
}

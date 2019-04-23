package com.bootdo.welcome.domain.admin;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 角色
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:55:53
 */
@ApiModel(value = "RoleDO", description = "角色") 
public class YXRoleDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//角色ID
	@ApiModelProperty(value = "角色ID")
	private Long id;
	//角色名称
	@ApiModelProperty(value = "角色名称")
	private String rname;
	//角色标识
	@ApiModelProperty(value = "角色标识")
	private String rsign;
	//备注
	@ApiModelProperty(value = "备注")
	private String remark;
	//学校唯一编码
	@ApiModelProperty(value = "学校唯一编码")
	private Integer uvCode;
	//角色排序
	@ApiModelProperty(value = "角色排序")
	private Integer order;
	//状态(1:启用,0:禁用)
	@ApiModelProperty(value = "状态(1:启用,0:禁用)")
	private Integer flag;

	/**
	 * 设置：角色ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：角色ID
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：角色名称
	 */
	public void setRname(String rname) {
		this.rname = rname;
	}
	/**
	 * 获取：角色名称
	 */
	public String getRname() {
		return rname;
	}
	/**
	 * 设置：角色标识
	 */
	public void setRsign(String rsign) {
		this.rsign = rsign;
	}
	/**
	 * 获取：角色标识
	 */
	public String getRsign() {
		return rsign;
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
	 * 设置：学校唯一编码
	 */
	public void setUvCode(Integer uvCode) {
		this.uvCode = uvCode;
	}
	/**
	 * 获取：学校唯一编码
	 */
	public Integer getUvCode() {
		return uvCode;
	}
	/**
	 * 设置：角色排序
	 */
	public void setOrder(Integer order) {
		this.order = order;
	}
	/**
	 * 获取：角色排序
	 */
	public Integer getOrder() {
		return order;
	}
	/**
	 * 设置：状态(1:启用,0:禁用)
	 */
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	/**
	 * 获取：状态(1:启用,0:禁用)
	 */
	public Integer getFlag() {
		return flag;
	}
}

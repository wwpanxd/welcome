package com.bootdo.welcome.domain.admin;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 迎新用户表,所有用户
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:56:29
 */
@ApiModel(value = "YXUserDO", description = "迎新用户表,所有用户") 
public class YXUserDO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//
	@ApiModelProperty(value = "")
	private Long id;
	//学校的唯一编码
	@ApiModelProperty(value = "学校的唯一编码")
	private Integer uvCode;
	//登录名
	@ApiModelProperty(value = "登录名")
	private String loginname;
	//用户名
	@ApiModelProperty(value = "用户名")
	private String name;
	//密码
	@ApiModelProperty(value = "密码")
	private String password;
	//归属部门id
	@ApiModelProperty(value = "归属部门id")
	private Long deptId;
	//状态 0:禁用，1:正常
	@ApiModelProperty(value = "状态 0:禁用，1:正常")
	private Integer flag;
	//职务
	@ApiModelProperty(value = "职务")
	private String post;
	//电话
	@ApiModelProperty(value = "电话")
	private String phone;
	//头像url
	@ApiModelProperty(value = "头像url")
	private String picUrl;

	public YXUserDO() {
		
	}
	
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
	 * 设置：学校的唯一编码
	 */
	public void setUvCode(Integer uvCode) {
		this.uvCode = uvCode;
	}
	/**
	 * 获取：学校的唯一编码
	 */
	public Integer getUvCode() {
		return uvCode;
	}
	/**
	 * 设置：登录名
	 */
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	/**
	 * 获取：登录名
	 */
	public String getLoginname() {
		return loginname;
	}
	/**
	 * 设置：用户名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：用户名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：归属部门id
	 */
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	/**
	 * 获取：归属部门id
	 */
	public Long getDeptId() {
		return deptId;
	}
	/**
	 * 设置：状态 0:禁用，1:正常
	 */
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	/**
	 * 获取：状态 0:禁用，1:正常
	 */
	public Integer getFlag() {
		return flag;
	}
	/**
	 * 设置：职务
	 */
	public void setPost(String post) {
		this.post = post;
	}
	/**
	 * 获取：职务
	 */
	public String getPost() {
		return post;
	}
	/**
	 * 设置：电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：电话
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：头像url
	 */
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	/**
	 * 获取：头像url
	 */
	public String getPicUrl() {
		return picUrl;
	}
}

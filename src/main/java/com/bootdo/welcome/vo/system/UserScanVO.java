package com.bootdo.welcome.vo.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="UserScanVO",description="用户筛选条件")
public class UserScanVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
  
	// 用户名
    @ApiModelProperty(value="登录名")
    private String username;
   
	// 用户真实姓名
    @ApiModelProperty(value="用户真实姓名")
    private String name;

    @ApiModelProperty(value="归属部门ID")
    private Long deptId;
   
    @ApiModelProperty(value="用户职务")
    private String post;
    //电话
    @ApiModelProperty(value="电话")
    private String phone;
    @ApiModelProperty(value="状态 0:禁用，1:正常")
    private Integer status;


    public UserScanVO() {
    	
    }
    public UserScanVO(String username, String name, Long deptId, String post, String phone, Integer status) {
		super();
		this.username = username;
		this.name = name;
		this.deptId = deptId;
		this.post = post;
		this.phone = phone;
		this.status = status;
	}

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Long getDeptId() {
		return deptId;
	}


	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}


	public String getPost() {
		return post;
	}


	public void setPost(String post) {
		this.post = post;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}
}

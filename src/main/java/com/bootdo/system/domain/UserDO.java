package com.bootdo.system.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ApiModel(value="UserDO",description="用户")
public class UserDO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty(value="用户ID")
    private Long userId;
  
	// 用户名
    @ApiModelProperty(value="登录名")
    private String username;
    // 用户真实姓名
    @ApiModelProperty(value="用户真实姓名")
    private String name;
    // 密码
    private String password;
    // 部门
    private Long deptId;
    private String deptName;
    // 邮箱
    private String email;
    //职务
    @ApiModelProperty(value="用户职务")
    private String post;
    //电话
    @ApiModelProperty(value="电话")
    private String phone;
    @ApiModelProperty(value="状态 0:禁用，1:正常")
    private Integer status;
    // 创建用户id
    private Date userIdCreate;
    // 创建时间
    private Date userIdModified;
    
    @ApiModelProperty(value="归属角色列表")
    private List<Long> roleIds;
    
    @ApiModelProperty(value="权限值list")
    List<String> perms;
    
    @ApiModelProperty(value="性别")
    private Long sex;
//    //出身日期
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private Date birth;
    
    @ApiModelProperty(value="头像url")
    private String picUrl;
    
	//图片ID
    private Long picId;
    
//    //现居住地
//    private String liveAddress;
//    //爱好
//    private String hobby;
//    //省份
//    private String province;
//    //所在城市
//    private String city;
//    //所在地区
//    private String district;

    public UserDO() {
    	
    }
    public UserDO(Long userId, String username, String name, String password) {
    	super();
    	this.userId = userId;
    	this.username = username;
    	this.name = name;
    	this.password = password;
    }
    public UserDO(Long userId, String username, String name, Long deptId, String post, String phone,List<String> perms) {
		super();
		this.userId = userId;
		this.username = username;
		this.name = name;
		this.deptId = deptId;
		this.post = post;
		this.phone = phone;
		this.perms=perms;
	}
    
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }

    public Long getSex() {
        return sex;
    }

    public void setSex(Long sex) {
        this.sex = sex;
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
	public Date getUserIdCreate() {
		return userIdCreate;
	}
	public void setUserIdCreate(Date userIdCreate) {
		this.userIdCreate = userIdCreate;
	}
	public Date getUserIdModified() {
		return userIdModified;
	}
	public void setUserIdModified(Date userIdModified) {
		this.userIdModified = userIdModified;
	}
	public List<String> getPerms() {
		return perms;
	}
	public void setPerms(List<String> perms) {
		this.perms = perms;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public Long getPicId() {
		return picId;
	}
	public void setPicId(Long picId) {
		this.picId = picId;
	}

  
}

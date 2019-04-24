package com.bootdo.system.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="UserVO",description="修改用户密码使用")
public class UserVO {

    /**
     * 旧密码
     */
	@ApiModelProperty(value="旧密码")
    private String pwdOld;
    /**
     * 新密码
     */
	@ApiModelProperty(value="新密码")
    private String pwdNew;
	
	@ApiModelProperty(value="要修改用户的用户id")
	private Long userid;

    public String getPwdOld() {
        return pwdOld;
    }

    public void setPwdOld(String pwdOld) {
        this.pwdOld = pwdOld;
    }

    public String getPwdNew() {
        return pwdNew;
    }

    public void setPwdNew(String pwdNew) {
        this.pwdNew = pwdNew;
    }

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}
}

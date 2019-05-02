package com.bootdo.system.shiro;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class LoginUserDO implements Serializable{
	 private static final long serialVersionUID = 1L;
	    
	    @ApiModelProperty(value="用户ID")
	    private Long userId;
		// 用户名
	    @ApiModelProperty(value="登录名")
	    private String username;
	    // 用户真实姓名
	    @ApiModelProperty(value="用户真实姓名")
	    private String name;
	    @ApiModelProperty(value="用户密码")
	    private String password;
		@ApiModelProperty(value = "学校唯一编码")
		private Integer uvCode;
		
		
		public LoginUserDO() {
		}
		
		public LoginUserDO(Long userId, String username, String name,String password, Integer uvCode) {
			super();
			this.userId = userId;
			this.username = username;
			this.name = name;
			this.password=password;
			this.uvCode = uvCode;
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
		public Integer getUvCode() {
			return uvCode;
		}
		public void setUvCode(Integer uvCode) {
			this.uvCode = uvCode;
		}
}

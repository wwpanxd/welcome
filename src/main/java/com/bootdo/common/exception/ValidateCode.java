package com.bootdo.common.exception;

public interface ValidateCode {
	
	
	/** 不能为空 **/
	String NOT_BLANK 						= "NotBlank";
	/** 不能为空 **/
	String NOT_BLANK_VALUE 					= "不能为空";
	
	/** 不能为空 **/
	String NOT_NULL 						= "NotNull";
	/** 不能为空 **/
	String NOT_NULL_VALUE 					= "不能为空";
	
	//=====================公共异常 100=====================
	String COMMON_DFS_ERROR 				= "100001";//DFS服务器异常
	String USER_SESSION_TIMEOUT 			= "100002"; //用户SESSION已超时,请重新登录
	
	//=====================登录错误 200=====================
	String LOGIN_ERROR 						= "200001"; //登录，用户或密码错误
	String USER_ADD_NO_PASSWORD 			= "200002"; //注册用户时,密码不能为空
	String SCORE_ADD_NULL_INPUT 			= "300001"; //请输入要保存的考核数据
	String ROLE_UPDATE_ADMIN 			= "200007"; //超级管理员角色只能后台修改
	String ROLE_DELETE_ADMIN 			= "200006"; //超级管理员角色不能删除
	
}

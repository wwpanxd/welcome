package com.bootdo.common.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.bootdo.common.utils.R;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
	
//	private Logger logger = LoggerFactory.getLogger(getClass());
//    @Autowired
//    LogService logService;

	//自定义http status，数据校验异常
	private final int STATUS_VALIDATE = 480;
	
	@ExceptionHandler(ValidateException.class)
    R handleControllerValidateException(HttpServletRequest request, ValidateException ex, HttpServletResponse response){
		 response.setStatus(480);
		 return R.error(Integer.parseInt(ex.getCode()), ex.getMsg());
    }
	
    @ExceptionHandler(AuthorizationException.class)
    public R handleAuthorizationException(AuthorizationException e, HttpServletRequest request, HttpServletResponse response) {
         response.setStatus(480);
		 return R.error(10001, "该资源未授权");
    }
    
    @ExceptionHandler(LockedAccountException.class)
    public R handleAuthorizationException(LockedAccountException e, HttpServletRequest request, HttpServletResponse response) {
         response.setStatus(480);
		 return R.error(20002, "账号已被锁定,请联系管理员");
    }
    
    
    @ExceptionHandler({RuntimeException.class})
    R handleControllerRuntimeException(RuntimeException ex,HttpServletResponse response){
        response.setStatus(480);
		 return R.error(500, ex.getMessage());
    } 
    
  @ExceptionHandler({Exception.class})
  R handleControllerException(HttpServletRequest request, HttpServletResponse response,Exception ex){
      int code = response.getStatus();
      response.setStatus(480);
      if (404 == code) {
          return R.error(404, ex.getMessage());
      } else if (403 == code) {
          return R.error(403, ex.getMessage());
      } else if (401 == code) {
          return R.error(403, ex.getMessage());
      } else {
          return R.error(500, ex.getMessage());
      }
  } 
    
//  @ExceptionHandler({MissingServletRequestParameterException.class})
//  String handleControllerMissException(HttpServletRequest request, HttpServletResponse response,MissingServletRequestParameterException ex){
//      return "MissingServletRequestParameterException";
//  }
    
//  @ExceptionHandler({Exception.class})
//  R handleControllerException(HttpServletRequest request, HttpServletResponse response,Exception ex){
//      int code = response.getStatus();
//      if (404 == code) {
//          return R.error(404, "未找到资源1");
//      } else if (403 == code) {
//          return R.error(403, "没有访问权限");
//      } else if (401 == code) {
//          return R.error(403, "登录过期");
//      } else {
//          return R.error(500, "服务器错误");
//      }
//  } 
	
}
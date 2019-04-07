package com.bootdo.common.exception;

import java.util.Locale;
import javax.annotation.Resource;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;


public class ValidateMessage {
	
	@Resource
	private MessageSource messageSource;
	
	@Bean
	public ExceptionHandlerAdvice exceptionHandlerAdvice(){
		return new ExceptionHandlerAdvice();
	}
	
	public String getMessage(String code,Object[] args,Locale locale){
		return messageSource.getMessage(code, args, locale);
	}
	
	public String getMessage(String code){
		return messageSource.getMessage(code, null, Locale.getDefault());
	}
	
	public ValidateException getBusinessError(String code){
		String message = getMessage("validate.error.business."+code);
		return new ValidateException(code,message);
	}
}

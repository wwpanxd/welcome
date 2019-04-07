package com.bootdo.common.exception;

public class ExceptionHandler {
	/**
	 * 检查exception如果有错误，则直接抛出校验异常
	 *
	 * @param result
	 *
	 */
	public static void handle(ValidateException exception){
		if(exception != null){
			throw exception;
		}
	}
	
	/**
	 * 检查errorMessage如果有错误，则直接抛出校验异常
	 * 
	 * @param result
	 *
	 */
	public static void handle(String errorcode , String errorMessage){
			throw  new ValidateException(errorcode,errorMessage);
	}

	
}

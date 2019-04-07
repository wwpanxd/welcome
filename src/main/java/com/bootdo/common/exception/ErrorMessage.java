package com.bootdo.common.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

public class ErrorMessage{
	private String field;
	private String code;
	private Object value;
	private String message;
	private String subCode;
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	public String getSubCode() {
		return subCode;
	}
	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}
	public static List<ErrorMessage> getErrorMessage(List<ObjectError> errors){
		List<ErrorMessage> list = new ArrayList<>();
		if(errors != null){
			for(ObjectError e : errors){
				FieldError fe = (FieldError) e;
				ErrorMessage msg = new ErrorMessage();
				msg.setCode(fe.getCode());
				msg.setMessage(fe.getDefaultMessage());
				msg.setValue(fe.getRejectedValue());
				msg.setField(fe.getField());
				list.add(msg);
			}
		}
		return list;
	}
	
}

package com.bootdo.common.utils;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class Base64Utils {
	
//	//base64字符串转byte[]
//		public static byte[] base64String2ByteFun(String base64Str){
//			return Base64.decodeBase64(base64Str);
//		}
//		//byte[]转base64
//		public static String byte2Base64StringFun(byte[] b){
//			return Base64.encodeBase64String(b);
//		}
	
	public static byte[] base64String2ByteFun(String base64Str){
		Decoder de=Base64.getDecoder();
		return de.decode(base64Str);
	}
	
	public static String byte2Base64StringFun(byte[] b){
		Encoder e = Base64.getEncoder();
		return e.encodeToString(b);
	}

}

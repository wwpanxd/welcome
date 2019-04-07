package com.bootdo.system.config;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * 使用alibaba JSON 作为http restful 数据对象
 * 
 * @author lvshengchao
 * @since  2018年4月2日 下午3:24:35
 */
public class AlibabaJsonHttpMessageConverters {
	@Bean
	public HttpMessageConverters messageConverters() {
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		
		List<MediaType> supportedMediaTypes = new ArrayList<>();
		supportedMediaTypes.add(new MediaType("application","json",Charset.forName("UTF-8")));
		supportedMediaTypes.add(new MediaType("text","html",Charset.forName("UTF-8")));
		fastConverter.setSupportedMediaTypes(supportedMediaTypes);
		
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		//JSON在引用同一个对象的时候出现$ref，Gson无法解析
		fastJsonConfig.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect);
		
		fastConverter.setFastJsonConfig(fastJsonConfig);
		
		HttpMessageConverter<?> converter = fastConverter;
		
		HttpMessageConverters converters = new HttpMessageConverters(converter);
		
		return converters;
	}
	
	
//	  @Override
//	    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//
//	        super.configureMessageConverters(converters);
//	        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//	        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//	        fastJsonConfig.setSerializerFeatures(
//	                SerializerFeature.PrettyFormat
//	        );
//	        fastConverter.setFastJsonConfig(fastJsonConfig);
//	        converters.add(fastConverter);
//	    }

	/**
	 * 使用alibaba JSON
	 * 
	 * @return
	 * 
	 */
//	@Bean
//	public HttpMessageConverters messageConverters() {
//		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//		
//		List<MediaType> supportedMediaTypes = new ArrayList<>();
//		supportedMediaTypes.add(new MediaType("application","json",Charset.forName("UTF-8")));
//		supportedMediaTypes.add(new MediaType("text","html",Charset.forName("UTF-8")));
//		fastConverter.setSupportedMediaTypes(supportedMediaTypes);
//		
//		FastJsonConfig fastJsonConfig = new FastJsonConfig();
//		//JSON在引用同一个对象的时候出现$ref，Gson无法解析
//		fastJsonConfig.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect);
//		
//		fastConverter.setFastJsonConfig(fastJsonConfig);
//		
//		HttpMessageConverter<?> converter = fastConverter;
//		
//		HttpMessageConverters converters = new HttpMessageConverters(converter);
//		
//		return converters;
//	}
}

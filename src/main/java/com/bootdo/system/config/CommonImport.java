package com.bootdo.system.config;

import org.springframework.context.annotation.Import;


@Import(value={ AlibabaJsonHttpMessageConverters.class, CommonConfiguration.class})
//@Import(value={ AlibabaJsonHttpMessageConverters.class})
public class CommonImport {

}

package com.jt.common.config;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
/**
 *通过此配置文件整合MVC
 * @author sunyizun
 *
 */
@ComponentScan(value="com.jt",includeFilters={@Filter(classes={Controller.class,ControllerAdvice.class})},useDefaultFilters=false)
@EnableWebMvc//启用mvc默认配置

public class AppServletConfig extends WebMvcConfigurerAdapter{//spring-mvc.xml
	/**配置视图解析器*/
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/pages/",".html");
	}

	/**整合fastjson库(提供了操作JSON的API0) */
	@Override
	public void configureMessageConverters(
			List<HttpMessageConverter<?>> converters) {
		//1.构建MessageConverter对象
		FastJsonHttpMessageConverter converter=
				new FastJsonHttpMessageConverter();
		//禁用循环引用问题(id)
		FastJsonConfig config = new FastJsonConfig();
		config.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect);
		//fastJson反序列化漏洞
		config.setSerializeConfig(SerializeConfig.globalInstance);
		converter.setFastJsonConfig(config);
		//2.配置MessageConverter对象
		List<MediaType> list=new ArrayList<>();
		list.add(new MediaType("text","html",
				Charset.forName("UTF-8")));
		list.add(new MediaType("application","json",
				Charset.forName("UTF-8")));
		converter.setSupportedMediaTypes(list);
		//3.将MessageConverter对象添加到converters容器
		converters.add(converter);
	}

	//假如项目需要拦截器等还可在此位置配置拦截器...	



}

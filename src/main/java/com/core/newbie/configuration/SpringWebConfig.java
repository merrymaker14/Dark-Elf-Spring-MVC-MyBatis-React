//package com.core.newbie.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.ResourceBundleMessageSource;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import org.springframework.web.servlet.view.JstlView;
//
//@EnableWebMvc
//@Configuration
//@ComponentScan({ "com.core.newbie.controller", "com.core.newbie.mapper", "com.core.newbie.service", "com.core.newbie.impl",
//		"com.core.newbie.exception", "com.core.newbie.validation" })
//public class SpringWebConfig extends WebMvcConfigurerAdapter {
//
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
//	}
//
//	@Bean
//	public InternalResourceViewResolver viewResolver() {
//		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//		viewResolver.setViewClass(JstlView.class);
//		viewResolver.setPrefix("/WEB-INF/views/jsp/");
//		viewResolver.setSuffix(".jsp");
//		return viewResolver;
//	}
//
//	@Bean
//	public ResourceBundleMessageSource messageSource() {
//		ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
//		rb.setBasenames(new String[] { "messages/messages", "messages/validation" });
//		return rb;
//	}
//
//}
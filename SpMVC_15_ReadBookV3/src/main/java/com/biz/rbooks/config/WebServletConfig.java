package com.biz.rbooks.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/*
 * xml이 없는 mvc project의 web.xml을 대신할 클래스인데
 * 실제 상황은 servlet-context.xml의 일부 기능을 추가하는 class
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.biz.rbooks.controller","com.biz.rbooks.service"})
public class WebServletConfig implements WebMvcConfigurer{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
		
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}
	
	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	
	
}

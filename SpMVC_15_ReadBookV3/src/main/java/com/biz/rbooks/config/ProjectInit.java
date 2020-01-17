package com.biz.rbooks.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
 * tomcat이 작동하면서 제일 먼저 호출할 클래스
 */
public class ProjectInit extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		//Class[] servlet = new Class[]{WebConfig.class};
		//return servlet;
		return new Class[] {WebServletConfig.class,MybatisConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		//String[] mapping = new String[]{"/","*.do"}; 
		//return mapping;
		return new String[] {"/","*.do"};
	}

	
	
	
}

package com.niit.configure;

import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.niit.config.DBConfig;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	//for socket implementation
	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		System.out.println("customizeRegistration");
		registration.setInitParameter("dispatchOptionsRequest", "true");
		registration.setAsyncSupported(true);
	}

	@Override
	protected Class<?>[] getRootConfigClasses() 
	{
		return new Class[]{WebResolver.class,DBConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() 
	{
		return  new String[] { "/" };
	}

	/*for character encoding in chat for messaging
	@Override
	protected Filter[] getServletFilters()
	{
		CahracterEncodingFilter encodingFilter=new CharacterEncodingFilter();
		encodingFilter.setEncoding(StandardCharsets.UTF_8.name());
		return new Filter[] {encodingFilter};
		
	}*/
	}

	
	

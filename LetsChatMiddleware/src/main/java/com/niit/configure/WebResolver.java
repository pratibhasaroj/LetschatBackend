package com.niit.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

	
	@Configuration
	@EnableWebMvc
	@ComponentScan("com.niit")
	public class WebResolver 
	{
		@Bean
		public InternalResourceViewResolver getViewResolver()
		{
			System.out.println("Resolver Called");
			InternalResourceViewResolver iRVResolver=new InternalResourceViewResolver();
			iRVResolver.setViewClass(JstlView.class);
			iRVResolver.setPrefix("/WEB-INF/jsp");
			iRVResolver.setSuffix(".jsp");
			return iRVResolver;
		}
}


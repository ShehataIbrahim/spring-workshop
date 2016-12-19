package com.ih.spring.config;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan({"com.ih.spring.components"})
@PropertySource("/WEB-INF/resources/jdbcConfig.properties")
public class WebMvcConfig extends WebMvcConfigurerAdapter{
	final static Logger logger=Logger.getLogger(WebMvcConfig.class.getName());
	@Value("${com.spring.jdbc.url}")
	private String connectionUrl;
	@Value("${com.spring.jdbc.driver.class}")
	private String driverClass;
	@Value("${com.spring.jdbc.username}")
	private String userName;
	@Value("${com.spring.jdbc.password}")
	private String password;

	 @Bean
	    public ViewResolver viewResolver() {
	        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	        viewResolver.setViewClass(JstlView.class);
	        viewResolver.setPrefix("/WEB-INF/views/");
	        viewResolver.setSuffix(".jsp");
	        return viewResolver;
	    }
	 @Bean(name = "dataSource")
	 public DriverManagerDataSource dataSource() {
	     DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	     driverManagerDataSource.setDriverClassName(driverClass);
	     driverManagerDataSource.setUrl(connectionUrl);
	     driverManagerDataSource.setUsername(userName);
	     driverManagerDataSource.setPassword(password);
	     return driverManagerDataSource;
	 }

}

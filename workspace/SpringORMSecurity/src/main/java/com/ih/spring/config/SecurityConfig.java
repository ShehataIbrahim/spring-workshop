package com.ih.spring.config;

import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@ComponentScan("com.ih.spring.samples.components")
@EnableGlobalMethodSecurity
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	final static Logger logger=Logger.getLogger(SecurityConfig.class.getName());
	 @Autowired
	 DataSource dataSource;
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(
        		   "SELECT NAME USERNAME, PASSWORD, ENABLED FROM SECURITY_USER WHERE NAME=?")
        .authoritiesByUsernameQuery(
         "SELECT NAME USERNAME, ROLE FROM USER_ROLES WHERE NAME=?");
    }
   
  @Override
    protected void configure(HttpSecurity http) throws Exception {
      http
          .authorizeRequests().filterSecurityInterceptorOncePerRequest(true)
              .antMatchers("/home").access("@permission.check(authentication,'ADMIN')")
              .antMatchers("/welcome").hasRole("USER").and().formLogin();
  }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
	  http.authorizeRequests().anyRequest().authenticated();/*
      .antMatchers("/welcome").authenticated().anyRequest().hasRole("USER") ;
  
  http.authorizeRequests().antMatchers("/home").authenticated().anyRequest().hasRole("ADMIN") ;*/
     /* http.authorizeRequests()
          .antMatchers("/**").authenticated().anyRequest().hasRole("USER").and().authorizeRequests()
          .antMatchers("/home").authenticated().anyRequest().hasRole("ADMIN");*/
    //}
/*  @Order(1)
    @Configuration
	public static class WelcomeConfig extends WebSecurityConfigurerAdapter {
		protected void configure(HttpSecurity http) throws Exception {
			logger.info("*****************************Welcome Config****************");
			http.authorizeRequests().antMatchers("/welcome").hasRole("USER").anyRequest().authenticated().and().formLogin(); ;

		}
	}
    @Configuration
	public static class HomeConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			logger.info("*****************************Home Config****************");
			http.authorizeRequests().antMatchers("/home").hasRole("ADMIN").anyRequest().authenticated().and().formLogin(); ;
		}
	}*/
  
}
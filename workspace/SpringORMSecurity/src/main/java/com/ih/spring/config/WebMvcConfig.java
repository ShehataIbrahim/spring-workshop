package com.ih.spring.config;

import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.ih.spring.components.orm.SecurityUser;

@Configuration
@EnableWebMvc
@ComponentScan({ "com.ih.spring.components" })
@PropertySource("/WEB-INF/resources/jdbcConfig.properties")
@Import({ SecurityConfig.class })
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	final static Logger logger = Logger.getLogger(WebMvcConfig.class.getName());
	@Value("${com.spring.jdbc.url}")
	private String connectionUrl;
	@Value("${com.spring.jdbc.driver.class}")
	private String driverClass;
	@Value("${com.spring.jdbc.username}")
	private String userName;
	@Value("${com.spring.jdbc.password}")
	private String password;
	@Value("${hibernate.dialect}")
	private String dialect;

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

	/*
	 * public SessionFactory sessionFactory(DataSource dataSource) {
	 * 
	 * LocalSessionFactoryBuilder sessionBuilder = new
	 * LocalSessionFactoryBuilder(dataSource);
	 * sessionBuilder.addAnnotatedClasses(SecurityUser.class);
	 * sessionBuilder.setProperties(getHibernateProperties()); SessionFactory
	 * factory=sessionBuilder.buildSessionFactory(); factory.openSession();
	 * return factory; }
	 * 
	 * @Autowired
	 * 
	 */
	@Bean(name = "sessionFactory")
	@Autowired

	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setHibernateProperties(getHibernateProperties());
		bean.setAnnotatedClasses(SecurityUser.class);
		/*logger.info("**********************************"+bean.getConfiguration());
		logger.info("**********************************"+bean.getObject());
		SessionFactory factory=bean.getConfiguration().buildSessionFactory();*/
		return bean;

	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", dialect);
		properties.put("hibernate.current_session_context_class", "thread");
		return properties;
	}
	// @Bean(name = "transactionTemplate")
	// public TransactionTemplate transactionTemplate()
	// {
	// HibernateTransactionManager manager=new
	// HibernateTransactionManager(sessionFactory());
	// return new TransactionTemplate(manager);
	// }
	//

	@Bean(name = "permission")
	public Checker permission() {
		return new Checker();
	}

	static class Checker {
		public boolean check(Authentication authentication, String customArg) {
			if (authentication.getPrincipal() instanceof UserDetails) {
				UserDetails details = (UserDetails) authentication.getPrincipal();
				for (GrantedAuthority auth : details.getAuthorities()) {
					if (customArg.equalsIgnoreCase(auth.getAuthority()))
						return true;
				}
				return false;
				// return details.getAuthorities().contains(customArg);
			} else {
				return false;
			}
		}
	}
}

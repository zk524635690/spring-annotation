package com.demo.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@PropertySource("classpath:/dbconfig.properties")
@Configuration
public class MainConfigOfPrefile implements EmbeddedValueResolverAware{

	@Value("${db.user}")
	private String user;
	@Value("${db.password}")
	private String password;
	@Value("${db.jdbcUrl}")
	private String jdbcUrl;
	private String driverClass;
	
	@Profile("test")
	@Bean("dataSourcetest")
	public DataSource dataSourcetest() throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(password);
		dataSource.setJdbcUrl(jdbcUrl);
		dataSource.setDriverClass(driverClass);
		return dataSource;
	}
	
	@Profile("dev")
	@Bean("dataSourcedev")
	public DataSource dataSourcedev() throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(password);
		dataSource.setJdbcUrl(jdbcUrl);
		dataSource.setDriverClass(driverClass);
		return dataSource;
	}
	
	
	
	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		String dirverClass = resolver.resolveStringValue("${db.dirverClass}");
		this.driverClass = dirverClass;
	}

}

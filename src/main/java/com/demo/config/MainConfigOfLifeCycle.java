package com.demo.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.demo.bean.Car;

@ComponentScan(value="com.demo.bean")
@Configuration
public class MainConfigOfLifeCycle {
	
	@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON,
			proxyMode=ScopedProxyMode.TARGET_CLASS)
	@Bean(initMethod="init",destroyMethod="detory")
	public Car car() {
		return new Car();
	}
}

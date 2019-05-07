package com.demo.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.demo.config.MainConfigOfPropertyValue;

public class IOCTestOfPropertyValue {
	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValue.class);
	
	@Test
	public void test() {
		System.out.println("IOC容器创建完成");
		Object bean = applicationContext.getBean("person");
		System.out.println(bean);
		
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		
		String property = environment.getProperty("person.nickName");
		System.out.println(property);
		applicationContext.close();
	}
}

package com.demo.test;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.bean.Dog;
import com.demo.config.MainConfigOfLifeCycle;

public class IOCTestOfLifeCycle {
	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
	
	@Test
	public void test() {
		System.out.println("IOC容器创建完成");
		applicationContext.getBean("car");
		
		applicationContext.close();
	}
}

package com.demo.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.config.MainConfigOfPrefile;

public class IOCTestOfPrefile {
	
	
	@Test
	public void test() {
		AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext();
		
		applicationContext.getEnvironment().setActiveProfiles("dev");
		applicationContext.register(MainConfigOfPrefile.class);
		applicationContext.refresh();
		
		System.out.println("IOC容器创建完成");
		String[] names = applicationContext.getBeanNamesForType(DataSource.class);
		for (String name : names) {
			System.out.println(name);
		}
		
		applicationContext.close();
	}
}

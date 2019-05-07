package com.demo.test;

import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.ext.ExtConfig;

public class IOCTestOfExt {
	
	@Test
	public void test() {
		AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(ExtConfig.class);
		
		applicationContext.publishEvent(new ApplicationEvent(new String("我发布的事件")) {
			private static final long serialVersionUID = 1L;
		});
		
		applicationContext.close();
		
	}
}

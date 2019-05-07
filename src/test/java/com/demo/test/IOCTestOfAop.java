package com.demo.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.aop.Calculator;
import com.demo.aop.MathCalculator;
import com.demo.config.MainConfigOfAop;

public class IOCTestOfAop {
	
	
	@Test
	public void test() {
		AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(MainConfigOfAop.class);
		
		Calculator mathCalculator = applicationContext.getBean(Calculator.class);
		mathCalculator.div(3, 1);
		
		applicationContext.close();
	}
}

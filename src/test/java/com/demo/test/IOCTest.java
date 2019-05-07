package com.demo.test;

import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import com.demo.bean.Person;
import com.demo.config.MainConfig02;
import com.demo.config.Mainconfig;

public class IOCTest {
	ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig02.class);
	
	@Test
	public void test03() {
		String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
		
		Environment environment = applicationContext.getEnvironment();
		String property = environment.getProperty("os.name");
		System.out.println(property);
		
		for (String name : beanNamesForType) {
			System.out.println(name);
		}
		
		Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);
		System.out.println(persons);
	}
	
	
	@SuppressWarnings("resource")
	@Test
	public void test02() {
		/*String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : beanDefinitionNames) {
			System.out.println(name);
		}*/
		
		System.out.println("IOC容器创建完成");
		
		/*Object bean = applicationContext.getBean("person");
		Object bean2 = applicationContext.getBean("person");
		System.out.println(bean == bean2);*/
		
		Object bean = applicationContext.getBean("colorFactoryBean");
		Object bean2 = applicationContext.getBean("colorFactoryBean");
		System.out.println("bean的类型:" + bean.getClass());
		System.out.println(bean == bean2);
		
		//获取FactoryBean本身
		Object bean3 = applicationContext.getBean("&colorFactoryBean");
		System.out.println("bean的类型:" + bean3.getClass());
	}
	
	
	@SuppressWarnings("resource")
	@Test
	public void test01() {
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : beanDefinitionNames) {
			System.out.println(name);
		}
	}
}

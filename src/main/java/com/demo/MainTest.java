package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.bean.Person;
import com.demo.config.Mainconfig;

public class MainTest {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		Person person = (Person) applicationContext.getBean("person");
		System.out.println(person);
		
		/*ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Mainconfig.class);
		Person person = applicationContext.getBean(Person.class);
		System.out.println(person);
		
		String[] beanNamesForPersonType = applicationContext.getBeanNamesForType(Person.class);
		
		for (String name : beanNamesForPersonType) {
			System.out.println(name);
		}*/
	}
}

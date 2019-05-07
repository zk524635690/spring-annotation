package com.demo.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.bean.Boss;
import com.demo.bean.Car;
import com.demo.bean.Color;
import com.demo.bean.Red;
import com.demo.config.MainConfigOfAutowired;
import com.demo.dao.BookDao;
import com.demo.service.BookService;

public class IOCTestOfautowired {
	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
	
	@Test
	public void test() {
		System.out.println("IOC容器创建完成");
		BookService bookService = applicationContext.getBean(BookService.class);
		System.out.println(bookService);
		
		BookDao bookDao = applicationContext.getBean(BookDao.class);
		System.out.println(bookDao);
		
		Car car = applicationContext.getBean(Car.class);
		System.out.println(car);
		
		Boss boss = applicationContext.getBean(Boss.class);
		System.out.println(boss);
		
		Color color = applicationContext.getBean(Color.class);
		System.out.println(color);
		
		System.out.println(applicationContext);
		
		applicationContext.close();
	}
}

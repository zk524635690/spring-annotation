package com.demo.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.config.MainConfigRepository;
import com.demo.service.BookService;

@SuppressWarnings("resource")
public class TestRepository {
	
	@Test
	public void test() {
		AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(MainConfigRepository.class);
		
		BookService bookService = (BookService) applicationContext.getBean("bookService");
		bookService.add();
	}
}

package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.demo.bean.Car;
import com.demo.bean.Color;
import com.demo.dao.BookDao;

@Configuration
@ComponentScan(value= {"com.demo.dao","com.demo.service",
		"com.demo.controller","com.demo.bean"})
public class MainConfigOfAutowired {

	@Primary
	@Bean("bookDao")
	public BookDao bookDao() {
		BookDao bookDao = new BookDao();
		bookDao.setLable("2");
		return bookDao;
	}
	
	@Bean
	public Color color(Car car) {
		Color color = new Color();
		color.setCar(car);
		return color;
	}
}

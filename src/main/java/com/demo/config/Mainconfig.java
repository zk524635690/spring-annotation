package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.demo.bean.Person;
import com.demo.service.BookService;

@Configuration
@ComponentScan(value="com.demo",includeFilters= {
		/*@Filter(type=FilterType.ANNOTATION,classes= {Controller.class}),
		@Filter(type=FilterType.ASSIGNABLE_TYPE,classes=BookService.class),*/
		@Filter(type=FilterType.CUSTOM,classes=MyFilterType.class)
},useDefaultFilters=false)
public class Mainconfig {
	
	@Bean("person")
	public Person getPerson() {
		return new Person("张三", 66);
	}
}

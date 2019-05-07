package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.demo.bean.Person;

@PropertySource(value= {"classpath:/person.properties"})
@Configuration
public class MainConfigOfPropertyValue {

	@Bean
	public Person person() {
		return new Person();
	}
}

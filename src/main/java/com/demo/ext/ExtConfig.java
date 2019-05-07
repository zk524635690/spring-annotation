package com.demo.ext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.demo.bean.Car;

@ComponentScan(basePackages= {"com.demo.ext"})
@Configuration
public class ExtConfig {

	@Bean
	public Car car() {
		return new Car();
	}

}

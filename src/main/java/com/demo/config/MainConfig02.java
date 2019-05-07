package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.demo.bean.Color;
import com.demo.bean.ColorFactoryBean;
import com.demo.bean.Person;
import com.demo.condition.LinuxCondition;
import com.demo.condition.MyImportBeanDefinitionRegistrar;
import com.demo.condition.MyImportSelector;
import com.demo.condition.WindowsCondition;

@Configuration
@Conditional(value= {WindowsCondition.class})
@Import(value= {Color.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
public class MainConfig02 {
	
//	@Scope("prototype")
	@Lazy
	@Bean("person")
	public Person getPerson() {
		System.out.println("给容器中添加Person");
		return new Person("张三", 66);
	}

	@Bean("bill")
	public Person person02() {
		return new Person("bill", 62);
	}
	
	@Conditional(value= {LinuxCondition.class})
	@Bean("linux")
	public Person person03() {
		return new Person("linux", 48);
	}
	
	@Bean
	public ColorFactoryBean colorFactoryBean() { 
		return new ColorFactoryBean();
	}
}

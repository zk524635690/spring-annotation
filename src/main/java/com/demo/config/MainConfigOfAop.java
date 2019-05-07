package com.demo.config;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.aspectj.autoproxy.AspectJAwareAdvisorAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.AbstractAdvisorAutoProxyCreator;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/***
 * 1.AspectJAutoProxyRegistrar注册bean
 * 		internalAutoProxyCreator=AnnotationAwareAspectJAutoProxyCreator
 * 
 * 2.AnnotationAwareAspectJAutoProxyCreator
 * 		->AspectJAwareAdvisorAutoProxyCreator
 * 			->AbstractAdvisorAutoProxyCreator
 * 				->AbstractAutoProxyCreator
 * 					->ProxyProcessorSupport
 * 						implements SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware
 *
 */


@Configuration
@ComponentScan("com.demo.aop")
@EnableAspectJAutoProxy
public class MainConfigOfAop {

}

package com.demo.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspects {

	private Object[] args;
	private String methodName;
	
	@Pointcut("execution(public int com.demo.aop.MathCalculator.*(..))")
	public void pointCut() {};
	
	@Before("pointCut()")
	public void logStart(JoinPoint joinpoint) {
		handleMethodName(joinpoint);
		System.out.println(methodName + "方法运行...参数列表是:{"+ Arrays.asList(args) +"}");
	}
	
	@After("com.demo.aop.LogAspects.pointCut()")
	public void logEnd() {
		System.out.println(methodName + "除法结束...");
	}
	
	@AfterReturning(value="pointCut()",returning="result")
	public void logReturn(Object result) {
		System.out.println("除法正常返回...运行结果是:{"+ result +"}");
	}
	
	@AfterThrowing(value="pointCut()",throwing="exception")
	public void logException(JoinPoint joinpoint,Exception exception) {
		System.out.println(methodName + "...异常信息是:{" + exception + "}");
	}

	private void handleMethodName(JoinPoint joinpoint) {
		args = joinpoint.getArgs();
		methodName = joinpoint.getSignature().getName();
	}
}

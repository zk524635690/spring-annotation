package com.demo.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class MathCalculator implements Calculator,InvocationHandler
{

	@Override
	public int div(int i, int j) {
		System.out.println("MathCalculator...div...");
		return i / j;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("方法名称-->" + method.getName() + " 方法参数-->" + Arrays.asList(args));
		Object result = method.invoke(this, args);
		return result;
	}
	
	public static void main(String[] args) {
		
		MathCalculator mathCalculator = new MathCalculator();
		Calculator proxy = (Calculator) Proxy.newProxyInstance(
				mathCalculator.getClass().getClassLoader(), 
				mathCalculator.getClass().getInterfaces(), 
				mathCalculator);
		
		proxy.div(1, 3);
	}
}

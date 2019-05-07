package com.demo.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MathCalculatorProxy implements InvocationHandler{
	//被代理的对象
	private Calculator target;
	
	public MathCalculatorProxy(Calculator calculator) {
		this.target = calculator;
	}

	public Calculator getMathCalculatorProxy() {
		return (Calculator) Proxy.newProxyInstance(this.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("方法名称-->" + method.getName() + " 方法参数-->" + Arrays.asList(args));
		Object result = method.invoke(target, args);
		return result;
	}
	
	public static void main(String[] args) {
		MathCalculator mathCalculator = new MathCalculator();
		Calculator proxy = new MathCalculatorProxy(mathCalculator).getMathCalculatorProxy();
		proxy.div(1, 2);
		
		//cglib代理
		Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(MathCalculator.class);
        
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println("before method run...");
                Object result = proxy.invokeSuper(obj, args);
                System.out.println("after method run...");
                return result;
            }
        });
        
        MathCalculator sample = (MathCalculator) enhancer.create();
        sample.div(1, 2);

	}


}

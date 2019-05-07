package com.demo.test;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Properties;

import org.junit.Test;

import com.demo.bean.Blue;

public class TestReflection {
	@Test
	public void reflectionTest() throws Exception {
		/*Class<Dog> dogClass = Dog.class;
		Dog dog = dogClass.newInstance();
		Field field = dogClass.getDeclaredField("applicationContext");
		field.setAccessible(true);
		System.out.println(field.get(dog));
		Method method = dogClass.getMethod("init");
		method.invoke(dog);
		
		ClassLoader classLoader = this.getClass().getClassLoader();
		Class<?> loadClass = classLoader.loadClass("com.demo.bean.Dog");
		System.out.println(loadClass.getName());*/
		
		ClassLoader classLoader = this.getClass().getClassLoader();
		InputStream resourceAsStream = classLoader.getResourceAsStream("person.properties");
		Properties properties = new Properties();
		properties.load(resourceAsStream);
		String property = properties.getProperty("person.nickName");
		System.out.println(property);
	}
	
	@Test
	public void testConstructor() throws Exception {
		/*String className = "com.demo.bean.Blue";
		Class<?> clazz = Class.forName(className);
		Blue newInstance = (Blue)clazz.newInstance();
		System.out.println(newInstance);*/
		/*Class clazz = Blue.class;
		Field[] fields = clazz.getFields();
		Field[] declaredFields = clazz.getDeclaredFields();
		for (Field field : declaredFields) {
			System.out.println(Modifier.toString(field.getModifiers()) 
					+ " " + field.getName());
		}*/
		
		Class<Blue> clazz = Blue.class;
		Field name = clazz.getDeclaredField("name");
		Blue blue = clazz.newInstance();
		name.setAccessible(true);
		name.set(blue, "laowang");
		System.out.println(blue);
	}
	
	@Test
	public void testMethod() throws Exception {
		Class<Blue> clazz = Blue.class;
		Method method = clazz.getMethod("toString");
		Blue blue = clazz.newInstance();
		Object invoke = method.invoke(blue);
		System.out.println(invoke);
		
		//调用静态方法
		Method method2 = clazz.getMethod("getColorName");
		Object invoke2 = method2.invoke(clazz);
		System.out.println(invoke2);
	}
}

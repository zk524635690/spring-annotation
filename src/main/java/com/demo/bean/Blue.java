package com.demo.bean;

import java.io.Serializable;

import com.demo.annotation.MyAnnotation;

@MyAnnotation
public class Blue extends Color<Blue> implements Comparable<Blue>,Serializable{
	private static final long serialVersionUID = 1L;
	private static String name;
	
	public static String getColorName() {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Blue o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "Blue [name=" + name + "]";
	}
}

package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.dao.BaseRepositroy;

public class BaseService<T> {
	
	@Autowired
	protected BaseRepositroy<T> repositroy;

	public void add() {
		System.out.println("add...");
	}
}

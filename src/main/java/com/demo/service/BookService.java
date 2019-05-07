package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.demo.bean.Book;
import com.demo.dao.BookDao;

@Service
public class BookService extends BaseService<Book>{

//	@Qualifier("bookDao")
	@Autowired(required=false)
	private BookDao bookDao;
	
	public void print() {
		System.out.println(bookDao);
	}

	@Override
	public String toString() {
		return "BookService [bookDao=" + bookDao + "]";
	}
	
}

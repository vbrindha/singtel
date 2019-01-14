package com.springexample.dao;

import java.util.ArrayList;
import java.util.List;
import com.springexample.model.Book;


import org.springframework.stereotype.Component;

@Component
public class BookDAO {
	private static List<Book> books;
	{
		books = new ArrayList();
		books.add(new Book(1,"book1"));
		books.add(new Book(2,"book2"));
		books.add(new Book(3,"book3"));
	}
	public List list() {
		return books;
	}
	public Book get(Integer id) {
		for (Book b: books) {
			if (b.getId() == id )
				return b;
		}
		return null;
	}
	public void createBook(Book b) {
		books.add(b);
		
	}
	
}

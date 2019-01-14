package com.springexample.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springexample.dao.BookDAO;
import com.springexample.model.Book;

@RestController
public class BookController {
	@Autowired 	
	private BookDAO bookDAO;
	
	@GetMapping("/books")
	public List getBooks() {
		return bookDAO.list();
	}
	@GetMapping("/books/{id}")
	public ResponseEntity getBook(@PathVariable("id") String id) {
		Book book = bookDAO.get(id);
		if (book == null)
			return new ResponseEntity("No book found for ID " + id, HttpStatus.NOT_FOUND);
	

	return new ResponseEntity(book, HttpStatus.OK);
	}	
	@PostMapping(value = "/books")
	public ResponseEntity createCustomer(@RequestBody Book book) {

		bookDAO.createBook(book);

		return new ResponseEntity(book, HttpStatus.OK);
	}
}

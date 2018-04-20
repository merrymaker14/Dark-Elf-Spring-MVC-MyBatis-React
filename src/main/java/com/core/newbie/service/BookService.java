package com.core.newbie.service;

import java.util.List;
import java.util.Map;

import com.core.newbie.model.Book;

public interface BookService {
	Book getBookById(int bookId);
    
    List<Book> getAll();
    
    List<Book> booksBySearch(Map parms);

	void update(Book book);
	
	int addBook(Book book);
	
	void delete(int id);
}

package com.core.newbie.impl;

import com.core.newbie.mapper.BookMapper;
//import com.core.newbie.model.Role;
import com.core.newbie.model.Book;
import com.core.newbie.service.BookService;
import java.util.Map;

import java.util.List;

//import java.util.HashSet;
//import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("bookService")
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;
    
    @Override
    public Book getBookById(final int bookId) {
        return bookMapper.selectByPrimaryKey(bookId);
    }
    
    @Override
    public List<Book> getAll() {
    	return bookMapper.findAll();
    }
    
    @Override
    public List<Book> booksBySearch(Map parms) {
    	return bookMapper.search(parms);
    }
    
    @Override
    public int addBook(Book book) {
    	return bookMapper.insert(book);
    }
    
    @Override
    public void update(Book book) {
    	bookMapper.updateByPrimaryKey(book);
    }
    
    @Override
    public void delete(int id) {
    	bookMapper.deleteByPrimaryKey(id);
    }
}

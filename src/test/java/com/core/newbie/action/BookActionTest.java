package com.core.newbie.action;

import com.alibaba.fastjson.JSON;
import com.core.newbie.model.Book;
import com.core.newbie.service.BookService;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
//@WebAppConfiguration
public class BookActionTest {
    private static final Logger logger = Logger.getLogger(UserActionTest.class);
    private BookService bookService;

    @Autowired
    public void setBookService(final BookService bookService) {
        this.bookService = bookService;
    }

    public BookService getBookService() {
        return bookService;
    }

    @Test
    public void test4() {
    	Book book = bookService.getBookById(1);
        logger.info(JSON.toJSON(book));
    }

    @Test
    public void test5() {
    	List<Book> books;
    	books = bookService.getAll();
        logger.info(JSON.toJSON(books));
    }
}

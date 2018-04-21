package com.core.newbie.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.core.newbie.model.Book;
import com.core.newbie.model.User;
import com.core.newbie.service.BookService;
import com.google.gson.Gson;

//import com.github.dumars.mybatis.pagination.annotation.Pagination;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RequestMethod;
//import com.github.dumars.mybatis.pagination.entity.Paginator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.core.newbie.validation.BookFormValidator;

@Controller
@RequestMapping("/book")
public class BookController {
    Logger logger = Logger.getLogger(BookController.class);

    @Autowired
    private BookService bookService;
    
//	BookFormValidator bookFormValidator;

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public String showBook(final HttpServletRequest request, final Model model) {
        final int bookId = Integer.parseInt(request.getParameter("id"));
        final Book book = bookService.getBookById(bookId);
        model.addAttribute("book", book);
        logger.debug("running in BookController.java -> showBook()");
        logger.info(JSON.toJSON(request.getRequestURI()));
        logger.info(JSON.toJSON(book));
        return "/book/showBook.jsp";
    }
    
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String books(@ModelAttribute User user, final HttpServletRequest request, final Model model) {
    	HttpSession session = request.getSession();
    	List<Book> books;
        if (request.getParameter("name") != null || request.getParameter("publishing_house") != null || request.getParameter("the_year_of_publishing") != null) {
        	Map<String, Object> parms = new HashMap<String, Object>();
        	if (request.getParameter("name") != "") {
        	    final String name = request.getParameter("name");
        	    parms.put("name", name);
        	}
        	if (request.getParameter("publishingHouse") != "") {
        	    final String publishingHouse = request.getParameter("publishingHouse");
        	    parms.put("publishing_house", publishingHouse);
        	}
        	if (request.getParameter("theYearOfPublishing") != "") {
        	    final int theYearOfPublishing = Integer.parseInt(request.getParameter("theYearOfPublishing"));
        	    parms.put("the_year_of_publishing", theYearOfPublishing);
        	}
        	logger.info(parms);
        	books = bookService.booksBySearch(parms);
        } else {
            books = bookService.getAll();
        }
        model.addAttribute("user", session.getAttribute("user"));
        model.addAttribute("books", books);
        logger.debug("running in BookController.java -> books()");
        logger.info(JSON.toJSON(request.getRequestURI()));
        logger.info(JSON.toJSON(books));
        return "/book/list.jsp";
    }
	
	@RequestMapping(value = "/api", method = RequestMethod.GET)
    public @ResponseBody JSONArray api(HttpServletResponse response) throws UnsupportedEncodingException {
		response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=UTF-8");
		
		List<Book> books2;
		books2 = bookService.getAll();
		JSONArray books = (JSONArray) JSON.toJSON(books2);		
		logger.info(books);
		return books;
	}
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addBook(@ModelAttribute("addForm") @Validated Book book,
			BindingResult result, Model model, 
			final RedirectAttributes redirectAttributes) {

		logger.info(book);
		
//		bookFormValidator.validate(book, result);	

		if (result.hasErrors()) {
			return "book/addform.jsp";
		} else {

			// Add message to flash scope
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Book updated successfully!");
			
			bookService.addBook(book);
			
			return "redirect:/book/book?id=" + book.getId();
		}
    }
    
//    @InitBinder
//    protected void initBinder(WebDataBinder binder) {
//    	binder.setValidator(bookFormValidator);
//    }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateBook(@ModelAttribute("updateForm") @Validated Book book,
			BindingResult result, Model model, 
			final RedirectAttributes redirectAttributes) {

		logger.info(book);
		
//		bookFormValidator.validate(book, result);	

		if (result.hasErrors()) {
			return "book/updateform.jsp";
		} else {

			// Add message to flash scope
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Book updated successfully!");
			
			bookService.update(book);
			
			return "redirect:/book/book?id=" + book.getId();
		}
    }
    
    // show search form
    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String search() {
        logger.info("Загрузка search");
        return "book/search.jsp";
    }
    
    @RequestMapping(value = { "/add" }, method = RequestMethod.GET)
    public String showAddBookForm(Model model) {
    	model.addAttribute("addForm", new Book());
    	
        return "/book/addform.jsp";
    }
    
    // show update form
 	@RequestMapping(value = "{id}/update", method = RequestMethod.GET)
 	public String showUpdateBookForm(@PathVariable("id") int id, Model model) {
 		logger.info(id);

 		Book book = bookService.getBookById(id);
 		model.addAttribute("updateForm", book);
 		
 		return "/book/updateform.jsp";

 	}
 	
    // delete book
 	@RequestMapping(value = "{id}/delete", method = RequestMethod.POST)
 	public @ResponseBody void deleteBook(@PathVariable("id") int id, 
 		final RedirectAttributes redirectAttributes) {

 		logger.info(id);

 		bookService.delete(id);
 		
// 		redirectAttributes.addFlashAttribute("css", "success");
// 		redirectAttributes.addFlashAttribute("msg", "Book is deleted!");
// 		
// 		return "redirect:/book/books";
 	}
}

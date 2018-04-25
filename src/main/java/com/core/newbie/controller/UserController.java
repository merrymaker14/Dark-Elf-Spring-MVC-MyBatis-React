package com.core.newbie.controller;

import com.alibaba.fastjson.JSON;
//import com.core.newbie.model.Book;
import com.core.newbie.model.User;
import com.core.newbie.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String showUser(final HttpServletRequest request, final Model model) {
        final int userId = Integer.parseInt(request.getParameter("id"));
        final User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        logger.debug("running in UserController.java -> showUser()");
        logger.info(JSON.toJSON(request.getRequestURI()));
        logger.info(JSON.toJSON(user));
        return "/user/showUser.jsp";
    }
    
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String users(final HttpServletRequest request, final Model model) {
        final List<User> users = userService.getAll();
        model.addAttribute("users", users);
        logger.debug("running in UserController.java -> users()");
        logger.info(JSON.toJSON(request.getRequestURI()));
        logger.info(JSON.toJSON(users));
        return "/user/list.jsp";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginUser(final HttpServletRequest request) {
    	Map<String, Object> parms = new HashMap<String, Object>();
    	final String login = request.getParameter("login");    	
    	String password = request.getParameter("password");
    	final List<User> passwords = userService.passwords();
    	for (User temp : passwords) {
	    	if (bCryptPasswordEncoder.matches(password, temp.getPassword())) {
		    	parms.put("login", login);
		    	logger.info(parms);
				User user2 = userService.login(parms);
				logger.info(JSON.toJSON(user2));
				HttpSession session = request.getSession();
				session.setAttribute("user", user2);
				break;
	    	}
    	}
		
		return "redirect:/book/books";
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutUser(final HttpServletRequest request) {	  
    	HttpSession session = request.getSession();
		session.removeAttribute("user");
		
		return "redirect:/home";
    }
}

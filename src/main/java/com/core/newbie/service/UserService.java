package com.core.newbie.service;

import java.util.List;
import java.util.Map;

import com.core.newbie.model.Book;
import com.core.newbie.model.User;

public interface UserService {
	User getUserById(int userId);

    void save(User user);
    
    List<User> getAll();
    
    List<User> passwords();
    
    User login(Map parms);
}
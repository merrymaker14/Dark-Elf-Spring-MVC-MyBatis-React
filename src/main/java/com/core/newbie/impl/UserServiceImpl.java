package com.core.newbie.impl;

import com.core.newbie.mapper.UserMapper;
import com.core.newbie.model.User;
import com.core.newbie.service.UserService;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;
    
    @Override
    public User getUserById(final int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public void save(final User user) {
    	user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    	userMapper.insert(user);
    }
    
    @Override
    public List<User> getAll() {
    	return userMapper.findAll();
    }
    
    @Override
    public List<User> passwords() {
    	return userMapper.selectPasswords();
    }
    
    @Override
    public User login(Map parms) {
    	return userMapper.loginUser(parms);
    }
}

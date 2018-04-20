package com.core.newbie.mapper;

import java.util.List;
import java.util.Map;

import com.core.newbie.model.Book;
import com.core.newbie.model.User;

public interface UserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);
    
    List<User> findAll();
    
    List<User> selectPasswords();
    
    User loginUser(Map parms);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}

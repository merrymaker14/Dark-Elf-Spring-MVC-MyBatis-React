package com.core.newbie.mapper;

import java.util.List;
import java.util.Map;

import com.core.newbie.model.Book;
import com.core.newbie.model.User;

public interface BookMapper {

    int deleteByPrimaryKey(Integer id);

    Book selectByPrimaryKey(Integer id);
    
    List<Book> findAll();
    
    List<Book> search(Map parms);

    int updateByPrimaryKeySelective(Book record);

    int insert(Book record);

    int updateByPrimaryKey(Book record);
}

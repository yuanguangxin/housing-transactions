package com.yyy.housingtransactions.dao;

import com.yyy.housingtransactions.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKey(User record);

    User selectByUsername(@Param("username") String username);

    User selectByUsernameAndPassword(User user);

    List<User> getAll(@Param("content") String content);
}
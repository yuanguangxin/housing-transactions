package com.yyy.housingtransactions.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yyy.housingtransactions.dao.UserMapper;
import com.yyy.housingtransactions.model.House;
import com.yyy.housingtransactions.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public User selectByUsername(String username){
        return userMapper.selectByUsername(username);
    }

    public User login(User user) {
        return userMapper.selectByUsernameAndPassword(user);
    }

    public int insert(User user){
        return userMapper.insert(user);
    }

    public User selById(Long id){
        return userMapper.selectByPrimaryKey(id);
    }

    public int update(User user){
        return userMapper.updateByPrimaryKey(user);
    }

    public int delUser(Long id){
        return userMapper.deleteByPrimaryKey(id);
    }

    public PageInfo<User> getAll(int pageNum,String content){
        PageHelper.startPage(pageNum, 10);
        List<User> list = userMapper.getAll(content);
        PageInfo<User> userPageInfo = new PageInfo<>(list);
        return userPageInfo;
    }
}

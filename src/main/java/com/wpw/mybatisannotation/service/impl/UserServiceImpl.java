package com.wpw.mybatisannotation.service.impl;

import com.wpw.mybatisannotation.service.UserService;
import com.wpw.mybatisannotation.entity.User;
import com.wpw.mybatisannotation.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务处理类
 *
 * @author wpw
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> listUser() {
        return userMapper.listUser();
    }

    @Override
    public List<User> listUserByUserName(String userName) {
        return userMapper.listUserByUserName(userName);
    }

    @Override
    public User select(String userName, String passWord) {
        return userMapper.select(userName, passWord);
    }

    @Override
    public User selectUser(String userName, String passWord) {
        return userMapper.selectUser(userName, passWord);
    }

    @Override
    public Integer saveUser(User user) {
        return userMapper.saveUser(user);
    }

    @Override
    public Integer updateUser(User user) {
        return  userMapper.updateUser(user);
    }

    @Override
    public Integer deleteUser(User user) {
        return  userMapper.deleteUser(user);
    }

    @Override
    public List<User> listPagination(User user) {
        return  userMapper.listPagination(user);
    }
}

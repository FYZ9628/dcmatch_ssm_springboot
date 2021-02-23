package com.example.dcmatch_ssm_springboot.service.impl;

import com.example.dcmatch_ssm_springboot.mapper.UserMapper;
import com.example.dcmatch_ssm_springboot.model.User;
import com.example.dcmatch_ssm_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int add(User user) {
        return userMapper.add(user);
    }

    @Override
    public int deleteById(int id) {
        return userMapper.deleteById(id);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public User findById(int id) {
        return userMapper.findById(id);
    }

    @Override
    public User findByAccount(String account) {
        return userMapper.findByAccount(account);
    }

    @Override
    public User getByAccountAndPassword(String account, String password) {
        return userMapper.getByAccountAndPassword(account, password);
    }

    @Override
    public User getByAccountAndName(String account, String name) {
        return userMapper.getByAccountAndName(account, name);
    }

    @Override
    public User findByPhone(String name) {
        return userMapper.findByPhone(name);
    }

    @Override
    public User getByPhoneAndPassword(String phone, String password) {
        return userMapper.getByPhoneAndPassword(phone, password);
    }

    @Override
    public User getByPhoneAndName(String phone, String name) {
        return userMapper.getByPhoneAndName(phone, name);
    }

    @Override
    public List<User> findAllByNameLike(String name) {
        return userMapper.findAllByNameLike(name);
}

    @Override
    public boolean accountIsExist(String account) {
        User user = findByAccount(account);
        return null!=user;
    }


}

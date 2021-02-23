package com.example.dcmatch_ssm_springboot.service;

import com.example.dcmatch_ssm_springboot.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    int add(User user);

    int deleteById(int id);

    int update(User user);

    List<User> getAllUser();

    User findById(int id);

    User findByAccount(String account);

    User getByAccountAndPassword(String account, String password);

    User getByAccountAndName(String account, String name);

    User findByPhone(String name);

    User getByPhoneAndPassword(String phone, String password);

    User getByPhoneAndName(String phone, String name);

    List<User> findAllByNameLike(String name);

    boolean accountIsExist(String account);
}

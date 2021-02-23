package com.example.dcmatch_ssm_springboot.mapper;

import com.example.dcmatch_ssm_springboot.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    int add(User user);

    int deleteById(@Param("id") int id);

    int update(User user);

    List<User> getAllUser();

    User findById(@Param("id") int id);

    User selectById(@Param("id") int id);

    User findByAccount(@Param("account") String account);

    User getByAccountAndPassword(@Param("account") String account,@Param("password") String password);

    User getByAccountAndName(String account,String name);

    User findByPhone(@Param("phone") String phone);

    User getByPhoneAndPassword(@Param("phone") String phone, @Param("password") String password);

    User getByPhoneAndName(@Param("phone") String phone, @Param("name") String name);

    List<User> findAllByNameLike(@Param("name") String name);
}

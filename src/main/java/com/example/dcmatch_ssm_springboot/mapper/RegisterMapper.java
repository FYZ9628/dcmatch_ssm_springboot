package com.example.dcmatch_ssm_springboot.mapper;

import com.example.dcmatch_ssm_springboot.model.Register;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RegisterMapper {
    int add(Register register);

    int deleteById(int id);

    int update(Register register);

    List<Register> getAllRegister();

    Register findById(int id);

    Register findByPhone(String phone);

    Register findByPhoneAndPassword(String phone, String password);
}

package com.example.dcmatch_ssm_springboot.service;

import com.example.dcmatch_ssm_springboot.model.Register;

import java.util.List;

public interface RegisterService {
    int add(Register register);

    int deleteById(int id);

    int update(Register register);

    List<Register> getAllRegister();

    Register findById(int id);

    Register findByPhone(String phone);

    Register findByPhoneAndPassword(String phone, String password);

    boolean isExist(int id);

    boolean phoneIsExist(String phone);
}

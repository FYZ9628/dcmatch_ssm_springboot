package com.example.dcmatch_ssm_springboot.service.impl;

import com.example.dcmatch_ssm_springboot.mapper.RegisterMapper;
import com.example.dcmatch_ssm_springboot.model.Register;
import com.example.dcmatch_ssm_springboot.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterServiceimpl implements RegisterService {

    @Autowired
    private RegisterMapper registerMapper;

    @Override
    public int add(Register register) {
        return registerMapper.add(register);
    }

    @Override
    public int deleteById(int id) {
        return registerMapper.deleteById(id);
    }

    @Override
    public int update(Register register) {
        return registerMapper.update(register);
    }

    @Override
    public List<Register> getAllRegister() {
        return registerMapper.getAllRegister();
    }

    @Override
    public Register findById(int id) {
        return registerMapper.findById(id);
    }

    @Override
    public Register findByPhone(String phone) {
        return registerMapper.findByPhone(phone);
    }

    @Override
    public Register findByPhoneAndPassword(String phone, String password) {
        return registerMapper.findByPhoneAndPassword(phone, password);
    }

    @Override
    public boolean isExist(int id) {
        Register register = findById(id);
        return null!=register;
    }

    @Override
    public boolean phoneIsExist(String phone) {
        Register register = findByPhone(phone);
        return null!=register;
    }
}

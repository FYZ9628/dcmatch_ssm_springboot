package com.example.dcmatch_ssm_springboot.service.impl;

import com.example.dcmatch_ssm_springboot.mapper.TeacherMapper;
import com.example.dcmatch_ssm_springboot.model.Teacher;
import com.example.dcmatch_ssm_springboot.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public int add(Teacher teacher) {
        return teacherMapper.add(teacher);
    }

    @Override
    public int deleteById(int id) {
        return teacherMapper.deleteById(id);
    }

    @Override
    public int update(Teacher teacher) {
        return teacherMapper.update(teacher);
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherMapper.getAllTeacher();
    }

    @Override
    public Teacher findById(int id) {
        return teacherMapper.findById(id);
    }

    @Override
    public Teacher findByUser_Account(String account) {
        return teacherMapper.findByUser_Account(account);
    }

    @Override
    public List<Teacher> findAllByUser_NameLikeOrUser_AccountLike(String keywords) {
        return teacherMapper.findAllByUser_NameLikeOrUser_AccountLike(keywords);
    }

}

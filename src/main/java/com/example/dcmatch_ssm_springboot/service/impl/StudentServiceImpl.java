package com.example.dcmatch_ssm_springboot.service.impl;

import com.example.dcmatch_ssm_springboot.mapper.StudentMapper;
import com.example.dcmatch_ssm_springboot.model.Student;
import com.example.dcmatch_ssm_springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int add(Student student) {
        return studentMapper.add(student);
    }

    @Override
    public int deleteById(int id) {
        return studentMapper.deleteById(id);
    }

    @Override
    public int update(Student student) {
        return studentMapper.update(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentMapper.getAllStudent();
    }

    @Override
    public Student findById(int id) {
        return studentMapper.findById(id);
    }

    @Override
    public List<Student> findAllByUser_NameLikeOrUser_AccountLike(String keywords) {
        return studentMapper.findAllByUser_NameLikeOrUser_AccountLike(keywords);
    }

    @Override
    public Student findByUser_Account(String account) {
        return studentMapper.findByUser_Account(account);
    }
}

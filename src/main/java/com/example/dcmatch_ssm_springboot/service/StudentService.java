package com.example.dcmatch_ssm_springboot.service;

import com.example.dcmatch_ssm_springboot.model.Student;

import java.util.List;

public interface StudentService {
    int add(Student student);

    int deleteById(int id);

    int update(Student student);

    List<Student> getAllStudent();

    Student findById(int id);

    List<Student> findAllByUser_NameLikeOrUser_AccountLike(String keywords);

    Student findByUser_Account(String account);
}

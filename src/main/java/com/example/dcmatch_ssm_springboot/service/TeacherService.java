package com.example.dcmatch_ssm_springboot.service;

import com.example.dcmatch_ssm_springboot.model.Teacher;

import java.util.List;

public interface TeacherService {
    int add(Teacher teacher);

    int deleteById(int id);

    int update(Teacher teacher);

    List<Teacher> getAllTeacher();

    Teacher findById(int id);

    Teacher findByUser_Account(String account);

    List<Teacher> findAllByUser_NameLikeOrUser_AccountLike(String keywords);
}

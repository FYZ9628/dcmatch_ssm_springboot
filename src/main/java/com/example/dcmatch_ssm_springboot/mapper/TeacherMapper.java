package com.example.dcmatch_ssm_springboot.mapper;

import com.example.dcmatch_ssm_springboot.model.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeacherMapper {
    int add(Teacher teacher);

    int deleteById(int id);

    int update(Teacher teacher);

    List<Teacher> getAllTeacher();

    Teacher findById(int id);

    Teacher findByUser_Account(String account);

    List<Teacher> findAllByUser_NameLikeOrUser_AccountLike(String keywords);
}

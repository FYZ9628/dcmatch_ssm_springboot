package com.example.dcmatch_ssm_springboot.mapper;

import com.example.dcmatch_ssm_springboot.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {
    int add(Student student);

    int deleteById(int id);

    int update(Student student);

    List<Student> getAllStudent();

    Student findById(int id);

    Student findByUser_Account(String account);

    List<Student> findAllByUser_NameLikeOrUser_AccountLike(String keywords);
}

package com.example.dcmatch_ssm_springboot.mapper;

import com.example.dcmatch_ssm_springboot.model.School;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SchoolMapper {
    int add(School school);

    int deleteById(int id);

    int update(School school);

    List<School> getAllSchool();

    School findById(int id);

    List<School> findAllByNameLike(String className);
}

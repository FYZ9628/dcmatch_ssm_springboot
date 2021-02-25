package com.example.dcmatch_ssm_springboot.service;

import com.example.dcmatch_ssm_springboot.model.School;

import java.util.List;

public interface SchoolService {
    int add(School school);

    int deleteById(int id);

    int update(School school);

    List<School> getAllSchool();

    School findById(int id);

    List<School> findAllByNameLike(String className);

    boolean isExist(int id);
}

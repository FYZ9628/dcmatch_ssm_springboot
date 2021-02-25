package com.example.dcmatch_ssm_springboot.service.impl;

import com.example.dcmatch_ssm_springboot.mapper.SchoolMapper;
import com.example.dcmatch_ssm_springboot.model.School;
import com.example.dcmatch_ssm_springboot.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    private SchoolMapper schoolMapper;

    @Override
    public int add(School school) {
        return schoolMapper.add(school);
    }

    @Override
    public int deleteById(int id) {
        return schoolMapper.deleteById(id);
    }

    @Override
    public int update(School school) {
        return schoolMapper.update(school);
    }

    @Override
    public List<School> getAllSchool() {
        return schoolMapper.getAllSchool();
    }

    @Override
    public School findById(int id) {
        return schoolMapper.findById(id);
    }

    @Override
    public List<School> findAllByNameLike(String className) {
        return schoolMapper.findAllByNameLike(className);
    }

    @Override
    public boolean isExist(int id) {
        School school = findById(id);
        return null!=school;
    }
}

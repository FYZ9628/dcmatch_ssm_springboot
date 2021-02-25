package com.example.dcmatch_ssm_springboot.controller;

import com.example.dcmatch_ssm_springboot.model.School;
import com.example.dcmatch_ssm_springboot.result.Result;
import com.example.dcmatch_ssm_springboot.result.Search;
import com.example.dcmatch_ssm_springboot.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class SchoolController {

    @Autowired
    SchoolService schoolService;

    @PostMapping("/api/addSchool")
    public School addSchool(@RequestBody School school) throws Exception {

        boolean bl = schoolService.isExist(school.getId());
        if (bl == true){
            return null;
        }else {
            schoolService.add(school);
            return school;
        }
    }

    @PostMapping("/api/updateSchool")
    public School updateSchool(@RequestBody School school) throws Exception {

        boolean bl = schoolService.isExist(school.getId());
        if (bl == true){
            schoolService.update(school);
            School school1 = schoolService.findById(school.getId());
            return school1;
        }else {
            return null;
        }
    }


    @PostMapping("/api/deleteSchool")
    public Result deleteSchool(@RequestBody School schoolId) throws Exception {
        //因为前端只是传了一个 id 过来，所以 teacherId 里面只有一个 id 没有其他信息
        //所以要再通过 id 查询 teacher 的其他信息
        School school = schoolService.findById(schoolId.getId());
        if (school != null){
            schoolService.deleteById(schoolId.getId());
            //   删除成功返回码 100
            return new Result(100);
        } else {
            //   删除失败返回码 400
            return new Result(400);
        }
    }

    @GetMapping("/api/getAllSchool")
    public List<School> getAllSchool() throws Exception {
        return schoolService.getAllSchool();
    }

    @PostMapping("/api/searchSchool")
    public List<School> findAllByNameLike(@RequestBody Search s) throws Exception {

        return schoolService.findAllByNameLike(s.getKeywords());
    }
}

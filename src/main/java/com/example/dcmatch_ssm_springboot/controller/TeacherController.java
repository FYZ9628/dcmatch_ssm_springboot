package com.example.dcmatch_ssm_springboot.controller;

import com.example.dcmatch_ssm_springboot.model.Teacher;
import com.example.dcmatch_ssm_springboot.model.User;
import com.example.dcmatch_ssm_springboot.result.Result;
import com.example.dcmatch_ssm_springboot.result.Search;
import com.example.dcmatch_ssm_springboot.result.SearchByInt;
import com.example.dcmatch_ssm_springboot.service.TeacherService;
import com.example.dcmatch_ssm_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @Autowired
    UserService userService;

    @PostMapping("/api/addTeacher")
    public Teacher addOrUpdateStudent(@RequestBody Teacher teacher) throws Exception {

        boolean bl = userService.accountIsExist(teacher.getUser().getAccount());
        if (bl == true){
            return null;
        }else {
            userService.add(teacher.getUser());
            User user1 = userService.findByAccount(teacher.getUser().getAccount());
            teacher.setUser(user1);
            teacherService.add(teacher);
            Teacher teacher1 = teacherService.findByUser_Account(teacher.getUser().getAccount());

            return teacher1;
        }
    }

    @PostMapping("/api/updateTeacher")
    public Teacher updateStudent(@RequestBody Teacher teacher) throws Exception {
        boolean bl = userService.accountIsExist(teacher.getUser().getAccount());
        if (bl == true){
            userService.update(teacher.getUser());
            teacherService.update(teacher);
            Teacher teacher1 = teacherService.findByUser_Account(teacher.getUser().getAccount());
            return teacher1;
        }else {
            return null;
        }
    }


    @PostMapping("/api/deleteTeacher")
    public Result deleteStudent(@RequestBody Teacher teacherId) throws Exception {
        //因为前端只是传了一个 id 过来，所以 teacherId 里面只有一个 id 没有其他信息
        //所以要再通过 id 查询 teacher 的其他信息
        Teacher teacher = teacherService.findById(teacherId.getId());
        if (teacher != null){
            teacherService.deleteById(teacherId.getId());
            userService.deleteById(teacher.getUser().getId());
            //   删除成功返回码 100
            return new Result(100);
        } else {
            //   删除失败返回码 400
            return new Result(400);
        }
    }

    @GetMapping("/api/getAllTeacher")
    public List<Teacher> getAllTeacher() throws Exception {
        return teacherService.getAllTeacher();
    }


    @PostMapping("/api/searchTeacherById")
    public Teacher getTeacherById(@RequestBody SearchByInt s) throws Exception {

        return teacherService.findById(s.getKeywords());
    }


    @PostMapping("/api/searchTeacherByAccount")
    public Teacher getTeacherByUser_Account(@RequestBody Search s) throws Exception {

        return teacherService.findByUser_Account(s.getKeywords());
    }


    @PostMapping("/api/searchTeacher")
    public List<Teacher> studentFindAllByNameLikeOrUser_AccountLike(@RequestBody Search s) throws Exception {

        return teacherService.findAllByUser_NameLikeOrUser_AccountLike(s.getKeywords());
    }

}

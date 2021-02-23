package com.example.dcmatch_ssm_springboot.controller;

import com.example.dcmatch_ssm_springboot.model.Student;
import com.example.dcmatch_ssm_springboot.model.User;
import com.example.dcmatch_ssm_springboot.result.Result;
import com.example.dcmatch_ssm_springboot.result.Search;
import com.example.dcmatch_ssm_springboot.result.SearchByInt;
import com.example.dcmatch_ssm_springboot.service.StudentService;
import com.example.dcmatch_ssm_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    UserService userService;

    @PostMapping("/api/addStudent")
    public Student addOrUpdateStudent(@RequestBody Student student) throws Exception {

        boolean bl = userService.accountIsExist(student.getUser().getAccount());
        if (bl == true){
            return null;
        }else {
            userService.add(student.getUser());
            User user1 = userService.findByAccount(student.getUser().getAccount());
            student.setUser(user1);
            studentService.add(student);
            Student student1 = studentService.findByUser_Account(student.getUser().getAccount());

            return student1;
        }
    }

    @PostMapping("/api/updateStudent")
    public Student updateStudent(@RequestBody Student student) throws Exception {
        boolean bl = userService.accountIsExist(student.getUser().getAccount());
        if (bl == true){
            userService.update(student.getUser());
            studentService.update(student);
            Student student1 = studentService.findByUser_Account(student.getUser().getAccount());
            return student1;
        }else {
            return null;
        }
    }

    @PostMapping("/api/deleteStudent")
    public Result deleteStudent(@RequestBody Student studentId) throws Exception {
        //因为前端只是传了一个 id 过来，所以 teacherId 里面只有一个 id 没有其他信息
        //所以要再通过 id 查询 teacher 的其他信息
        Student student = studentService.findById(studentId.getId());
        if (student != null){
            studentService.deleteById(studentId.getId());
            userService.deleteById(student.getUser().getId());
            //   删除成功返回码 100
            return new Result(100);
        } else {
            //   删除失败返回码 400
            return new Result(400);
        }
    }

    @GetMapping("/api/getAllStudent")
    public List<Student> getAllStudent() throws Exception {
        return studentService.getAllStudent();
    }


    @PostMapping("/api/searchStudentById")
    public Student getStudentById(@RequestBody SearchByInt s) throws Exception {

        return studentService.findById(s.getKeywords());
    }


    @PostMapping("/api/searchStudentByAccount")
    public Student getStudentByUser_Account(@RequestBody Search s) throws Exception {

        return studentService.findByUser_Account(s.getKeywords());
    }


    @PostMapping("/api/searchStudent")
    public List<Student> studentFindAllByNameLikeOrUser_AccountLike(@RequestBody Search s) throws Exception {

        return studentService.findAllByUser_NameLikeOrUser_AccountLike(s.getKeywords());
    }
}

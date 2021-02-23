package com.example.dcmatch_ssm_springboot.controller;

import com.example.dcmatch_ssm_springboot.model.User;
import com.example.dcmatch_ssm_springboot.result.Result;
import com.example.dcmatch_ssm_springboot.result.Search;
import com.example.dcmatch_ssm_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/api/addUser")
    public User addUser(@RequestBody User user) throws Exception {

        boolean bl = userService.accountIsExist(user.getAccount());
        if (bl == true){
            return null;
        }else {
            userService.add(user);
            User user1 = userService.findByAccount(user.getAccount());
            return user1;
        }
    }

    @PostMapping("/api/updateUser")
    public User updateUser(@RequestBody User user) throws Exception {
        boolean bl = userService.accountIsExist(user.getAccount());
        if (bl == true){
            userService.update(user);
            User user1 = userService.findByAccount(user.getAccount());
            return user1;
        }else {
            return null;
        }
    }

    @PostMapping("/api/deleteUser")
    public Result deleteUser(@RequestBody User userId) throws Exception {
        //因为前端只是传了一个 id 过来，所以 teacherId 里面只有一个 id 没有其他信息
        //所以要再通过 id 查询 teacher 的其他信息
        User user = userService.findById(userId.getId());
        if (user != null){
            userService.deleteById(user.getId());
            //   删除成功返回码 100
            return new Result(100);
        } else {
            //   删除失败返回码 400
            return new Result(400);
        }
    }

    @GetMapping("/api/getAllUser")
    public List<User> getAllUser() throws Exception {
        return userService.getAllUser();
    }

    @PostMapping("/api/searchUser")
    public  List<User>  findAllByNameLike(@RequestBody Search s) throws Exception {

        return userService.findAllByNameLike(s.getKeywords());
    }

    @PostMapping("/api/searchUserByAccount")
    public User getUserByAccount(@RequestBody Search s) throws Exception {

        return userService.findByAccount(s.getKeywords());
    }

    @PostMapping("/api/searchUserByPhone")
    public User getUserByPhone(@RequestBody Search s) throws Exception {

        return userService.findByPhone(s.getKeywords());
    }
}

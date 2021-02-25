package com.example.dcmatch_ssm_springboot.controller.login;

import com.example.dcmatch_ssm_springboot.model.User;
import com.example.dcmatch_ssm_springboot.result.Result;
import com.example.dcmatch_ssm_springboot.result.UserPost;
import com.example.dcmatch_ssm_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

@CrossOrigin
@RestController
public class AdminLoginController {
    @Autowired
    UserService userService;

    @PostMapping(value = "api/admin_login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String account = requestUser.getAccount();
        account = HtmlUtils.htmlEscape(account);

        // 返回码：100对应管理员，200对应教师，300对应学生，400是错误码
        User user = userService.getByAccountAndPassword(account, requestUser.getPassword());
        if (null == user) {
            return new Result(400);
        } else if (user.getType() == 1){
            String mAccount = user.getAccount();
            String mPassword = user.getPassword();
            String mName = user.getName();
            return new Result(100, mAccount, mPassword, mName);
        } else {
            return new Result(400);
        }
    }

    @PostMapping("/api/updatePassword")
    public User updatePassword(@RequestBody UserPost userPost) throws Exception {

        User user = userService.getByAccountAndPassword(userPost.getAccount(), userPost.getOldPassword());
        if (user != null){
            User newUser = new User();
            User userId = userService.findByAccount(userPost.getAccount());
            newUser.setId(userId.getId());
            newUser.setAccount(userPost.getAccount());
            newUser.setPassword(userPost.getNewPassword());
            newUser.setType(user.getType());

            userService.add(newUser);
            return newUser;
        }else {
            return null;
        }
    }
}

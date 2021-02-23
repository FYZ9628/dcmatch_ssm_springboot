package com.example.dcmatch_ssm_springboot.controller;

import com.example.dcmatch_ssm_springboot.model.Organizer;
import com.example.dcmatch_ssm_springboot.model.User;
import com.example.dcmatch_ssm_springboot.result.Result;
import com.example.dcmatch_ssm_springboot.result.Search;
import com.example.dcmatch_ssm_springboot.result.SearchByInt;
import com.example.dcmatch_ssm_springboot.service.OrganizerService;
import com.example.dcmatch_ssm_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class OrganizerController {

    @Autowired
    OrganizerService organizerService;
    @Autowired
    UserService userService;

    @PostMapping("/api/addOrganizer")
    public Organizer addOrganizer(@RequestBody Organizer organizer) throws Exception {

        boolean bl = userService.accountIsExist(organizer.getUser().getAccount());
        if (bl == true){
            return null;
        }else {
            userService.add(organizer.getUser());
            User user1 = userService.findByAccount(organizer.getUser().getAccount());
            organizer.setUser(user1);
            organizerService.add(organizer);
            Organizer organizer1 = organizerService.findByUser_Account(organizer.getUser().getAccount());

            return organizer1;
        }
    }

    @PostMapping("/api/updateOrganizer")
    public Organizer updateOrganizer(@RequestBody Organizer organizer) throws Exception {
        boolean bl = userService.accountIsExist(organizer.getUser().getAccount());
        if (bl == true){
            userService.update(organizer.getUser());
            organizerService.update(organizer);
            Organizer organizer1 = organizerService.findByUser_Account(organizer.getUser().getAccount());
            return organizer1;
        }else {
            return null;
        }
    }


    @PostMapping("/api/deleteOrganizer")
    public Result deleteOrganizer(@RequestBody Organizer organizerId) throws Exception {
        //因为前端只是传了一个 id 过来，所以 teacherId 里面只有一个 id 没有其他信息
        //所以要再通过 id 查询 teacher 的其他信息
        Organizer organizer = organizerService.findById(organizerId.getId());
        if (organizer != null){
            organizerService.deleteById(organizerId.getId());
            userService.deleteById(organizer.getUser().getId());
            //   删除成功返回码 100
            return new Result(100);
        } else {
            //   删除失败返回码 400
            return new Result(400);
        }
    }

    @GetMapping("/api/getAllOrganizer")
    public List<Organizer> getAllOrganizer() throws Exception {
        return organizerService.getAllOrganizer();
    }

    @GetMapping("/api/organizerInfo")
    public List<Organizer> organizerList() throws Exception {
        return organizerService.getAllOrganizer();
    }

    @PostMapping("/api/searchOrganizerById")
    public Organizer getOrganizerById(@RequestBody SearchByInt s) throws Exception {

        return organizerService.findById(s.getKeywords());
    }


    @PostMapping("/api/searchOrganizerByAccount")
    public Organizer getOrganizerByUser_Account(@RequestBody Search s) throws Exception {

        return organizerService.findByUser_Account(s.getKeywords());
    }


    @PostMapping("/api/searchOrganizer")
    public List<Organizer> FindAllByNameLikeOrUser_AccountLike(@RequestBody Search s) throws Exception {

        return organizerService.findAllByUser_NameLikeOrUser_AccountLike(s.getKeywords());
    }
}

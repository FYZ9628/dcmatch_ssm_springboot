package com.example.dcmatch_ssm_springboot.controller;

import com.example.dcmatch_ssm_springboot.model.Notice;
import com.example.dcmatch_ssm_springboot.result.Result;
import com.example.dcmatch_ssm_springboot.result.Search;
import com.example.dcmatch_ssm_springboot.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    @PostMapping("/api/addNotice")
    public Notice addClass(@RequestBody Notice notice) throws Exception {

        boolean bl = noticeService.isExist(notice.getId());
        if (bl == true){
            return null;
        }else {
            noticeService.add(notice);
            return notice;
        }
    }

    @PostMapping("/api/updateNotice")
    public Notice updateStudent(@RequestBody Notice notice) throws Exception {

        boolean bl = noticeService.isExist(notice.getId());
        if (bl == true){
            noticeService.update(notice);
            Notice notice1 = noticeService.findById(notice.getId());
            return notice1;
        }else {
            return null;
        }
    }

    @PostMapping("/api/deleteNotice")
    public Result deleteStudent(@RequestBody Notice noticeId) throws Exception {
        //因为前端只是传了一个 id 过来，所以 teacherId 里面只有一个 id 没有其他信息
        //所以要再通过 id 查询 teacher 的其他信息
        Notice notice = noticeService.findById(noticeId.getId());
        if (notice != null){
            noticeService.deleteById(noticeId.getId());
            //   删除成功返回码 100
            return new Result(100);
        } else {
            //   删除失败返回码 400
            return new Result(400);
        }
    }

    @GetMapping("/api/getAllNotice")
    public List<Notice> getAllNotice() throws Exception {
        return noticeService.getAllNotice();
    }

    @PostMapping("/api/searchNotice")
    public List<Notice> findAllByTitleLike(@RequestBody Search s) throws Exception {

        return noticeService.findAllByTitleLike(s.getKeywords());
    }

    @PostMapping("/api/searchNoticeByOrganizerAccount")
    public List<Notice> findAllByOrganizerAccount(@RequestBody Search s) throws Exception {

        return noticeService.findAllByOrganizer_User_Account(s.getKeywords());
    }
}

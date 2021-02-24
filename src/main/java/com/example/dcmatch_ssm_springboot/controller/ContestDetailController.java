package com.example.dcmatch_ssm_springboot.controller;

import com.example.dcmatch_ssm_springboot.model.ContestDetail;
import com.example.dcmatch_ssm_springboot.result.Result;
import com.example.dcmatch_ssm_springboot.result.Search;
import com.example.dcmatch_ssm_springboot.result.SearchByInt;
import com.example.dcmatch_ssm_springboot.service.ContestDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ContestDetailController {

    @Autowired
    ContestDetailService contestDetailService;

    @GetMapping("/api/getAllContestDetail")
    public List<ContestDetail> getAllContestDetail() throws Exception {
        return contestDetailService.getAllContestDetail();
    }

    @PostMapping("/api/searchContestDetail")
    public List<ContestDetail> findAllByContestTitleLike(@RequestBody Search s) throws Exception {

        return contestDetailService.findAllByContestTitleLikeOrOrganizer_User_NameLike(s.getKeywords());
    }

    @PostMapping("/api/searchContestDetailById")
    public ContestDetail findById(@RequestBody SearchByInt s) throws Exception {

        return contestDetailService.findById(s.getKeywords());
    }


    @PostMapping("/api/searchContestDetailByContestTitle")
    public ContestDetail findByContestTitle(@RequestBody Search s) throws Exception {

        return contestDetailService.findByContestTitle(s.getKeywords());
    }

    @PostMapping("/api/searchContestDetailByOrganizerAccount")
    public List<ContestDetail> findAllByOrganizerAccount(@RequestBody Search s) throws Exception {

        return contestDetailService.findAllByOrganizer_User_Account(s.getKeywords());
    }

    @PostMapping("/api/addContestDetail")
    public ContestDetail addContestDetail(@RequestBody ContestDetail contestDetail) throws Exception {

        boolean bl = contestDetailService.isExist(contestDetail.getId());
        if (bl == true){
            return null;
        }else {

            contestDetailService.add(contestDetail);
            ContestDetail contestDetail1 = contestDetailService.findByContestTitle(contestDetail.getContestTitle());
            return contestDetail1;
        }
    }

    @PostMapping("/api/updateContestDetail")
    public ContestDetail updateContestDetail(@RequestBody ContestDetail contestDetail) throws Exception {

        boolean bl = contestDetailService.isExist(contestDetail.getId());
        if (bl == true){
            contestDetailService.update(contestDetail);
            ContestDetail contestDetail1 = contestDetailService.findById(contestDetail.getId());
            return contestDetail1;
        }else {
            return null;
        }
    }


    @PostMapping("/api/deleteContestDetail")
    public Result deleteContestDetail(@RequestBody ContestDetail contestDetailId) throws Exception {
        //因为前端只是传了一个 id 过来，所以 teacherId 里面只有一个 id 没有其他信息
        //所以要再通过 id 查询 teacher 的其他信息
        ContestDetail contestDetail = contestDetailService.findById(contestDetailId.getId());
        if (contestDetail != null){
            contestDetailService.deleteById(contestDetailId.getId());
            //   删除成功返回码 100
            return new Result(100);
        } else {
            //   删除失败返回码 400
            return new Result(400);
        }
    }
}

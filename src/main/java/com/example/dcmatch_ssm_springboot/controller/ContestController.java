package com.example.dcmatch_ssm_springboot.controller;

import com.example.dcmatch_ssm_springboot.model.Contest;
import com.example.dcmatch_ssm_springboot.model.ContestDetail;
import com.example.dcmatch_ssm_springboot.model.Organizer;
import com.example.dcmatch_ssm_springboot.model.Student;
import com.example.dcmatch_ssm_springboot.result.Result;
import com.example.dcmatch_ssm_springboot.result.Search;
import com.example.dcmatch_ssm_springboot.result.SearchByInt;
import com.example.dcmatch_ssm_springboot.service.ContestDetailService;
import com.example.dcmatch_ssm_springboot.service.ContestService;
import com.example.dcmatch_ssm_springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ContestController {

    @Autowired
    ContestService contestService;
    @Autowired
    StudentService studentService;
    @Autowired
    ContestDetailService contestDetailService;

    //每一个报名的学生都会产生一个比赛记录，只是contest添加，但contestDetail不用添加
    //当contestDetail删除记录时，contest里所有有关的比赛记录都要被删除
    @PostMapping("/api/addContest")
    public Contest addContest(@RequestBody Contest contest) throws Exception {

        boolean bl = contestService.isExist(contest.getId());
        if (bl == true){
            return null;
        }else {
            contestService.add(contest);
            List<Contest> contestList = contestService.getAllContest();
            return contestList.get(contestList.size()-1);
        }
    }

    @PostMapping("/api/updateContest")
    public Contest updateContest(@RequestBody Contest contest) throws Exception {

        boolean bl = contestService.isExist(contest.getId());
        if (bl == true){
            contestService.update(contest);
            Contest contest1 = contestService.findById(contest.getId());
            return contest1;
        }else {
            return null;
        }
    }


    @PostMapping("/api/deleteContest")
    public Result deleteContest(@RequestBody Contest contestId) throws Exception {
        //因为前端只是传了一个 id 过来，所以 teacherId 里面只有一个 id 没有其他信息
        //所以要再通过 id 查询 teacher 的其他信息
        Contest contest = contestService.findById(contestId.getId());
        if (contest != null){
            contestService.deleteById(contestId.getId());
            //   删除成功返回码 100
            return new Result(100);
        } else {
            //   删除失败返回码 400
            return new Result(400);
        }
    }

    @GetMapping("/api/getAllContest")
    public List<Contest> getAllContestDetail() throws Exception {

        List<Contest> contestList = contestService.getAllContest();
        for (int i = 0; i < contestList.size(); i++) {
            Student student = studentService.findById(contestList.get(i).getStudent().getId());
            contestList.get(i).setStudent(student);
        }
        return contestList;
    }

    @PostMapping("/api/searchContestById")
    public Contest findByContestId(@RequestBody SearchByInt searchByInt) throws Exception {

        Contest contest = contestService.findById(searchByInt.getKeywords());
        Student student = studentService.findById(contest.getStudent().getId());
        contest.setStudent(student);
        return contest;
    }

    @PostMapping("/api/searchContestByContestDetailId")
    public List<Contest> findByContestDetailId(@RequestBody SearchByInt searchByInt) throws Exception {

        List<Contest> contestList = contestService.findAllByContestDetail_Id(searchByInt.getKeywords());
        for (int i = 0; i < contestList.size(); i++) {
            Student student = studentService.findById(contestList.get(i).getStudent().getId());
            contestList.get(i).setStudent(student);
        }
        return contestList;
    }

    //有 student，没有 Organizer（在ContestDetail中）
    @PostMapping("/api/searchContestByStudentAccount")
    public List<Contest> findAllByStudentAccount(@RequestBody Search s) throws Exception {

        List<Contest> contestList = contestService.findAllByStudent_User_Account(s.getKeywords());
        for (int i = 0; i < contestList.size(); i++) {
            ContestDetail contestDetail = contestDetailService.findById(contestList.get(i).getContestDetail().getId());
            contestList.get(i).setContestDetail(contestDetail);
        }
        return contestList;
    }

    //有 Organizer（在ContestDetail中） ，没有 student
    @PostMapping("/api/searchContestByOrganizerAccount")
    public List<Contest> findAllByOrganizerAccount(@RequestBody Search s) throws Exception {

        List<Contest> contestList = contestService.findAllByContestDetail_Organizer_User_Account(s.getKeywords());
        for (int i = 0; i < contestList.size(); i++) {
            Student student = studentService.findById(contestList.get(i).getStudent().getId());
            contestList.get(i).setStudent(student);
        }
        return contestList;
    }

    //根据比赛标题或举办方账号查询
    //给学生端用，也可以作为给举办方总结用，就像支付宝的年度总结
    @PostMapping("/api/searchContest_for_Student")
    public List<Contest> findAllByContestTitleLikeOrOrganizerAccount(@RequestBody Search s) throws Exception {

        List<Contest> contestList = contestService.findAllByContestDetail_ContestTitleLikeOrContestDetail_Organizer_User_AccountLike(s.getKeywords());
        for (int i = 0; i < contestList.size(); i++) {
            Student student = studentService.findById(contestList.get(i).getStudent().getId());
            contestList.get(i).setStudent(student);
        }
        return contestList;
    }

    //根据比赛标题或学生账号查询
    //给举办方端用，也可以作为给学生总结用，就像支付宝的年度总结
    @PostMapping("/api/searchContest_for_Organizer")
    public List<Contest> findAllByContestTitleLikeOrStudentAccount(@RequestBody Search s) throws Exception {

        List<Contest> contestList = contestService.findAllByContestDetail_ContestTitleLikeOrStudent_User_AccountLike(s.getKeywords());
        for (int i = 0; i < contestList.size(); i++) {
            ContestDetail contestDetail = contestDetailService.findById(contestList.get(i).getContestDetail().getId());
            contestList.get(i).setContestDetail(contestDetail);
        }
        return contestList;
    }

}

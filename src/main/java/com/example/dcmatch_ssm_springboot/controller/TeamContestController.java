package com.example.dcmatch_ssm_springboot.controller;

import com.example.dcmatch_ssm_springboot.model.ContestDetail;
import com.example.dcmatch_ssm_springboot.model.Student;
import com.example.dcmatch_ssm_springboot.model.TeamContest;
import com.example.dcmatch_ssm_springboot.model.TeamContestList;
import com.example.dcmatch_ssm_springboot.result.Result;
import com.example.dcmatch_ssm_springboot.result.Search;
import com.example.dcmatch_ssm_springboot.result.SearchByInt;
import com.example.dcmatch_ssm_springboot.result.SearchForTeamSignUp;
import com.example.dcmatch_ssm_springboot.service.ContestDetailService;
import com.example.dcmatch_ssm_springboot.service.StudentService;
import com.example.dcmatch_ssm_springboot.service.TeamContestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TeamContestController {

    @Autowired
    TeamContestService teamContestService;
    @Autowired
    StudentService studentService;
    @Autowired
    ContestDetailService contestDetailService;

    @GetMapping("/api/getAllTeamContest")
    public List<TeamContest> getAllTeamContest() throws Exception {

        List<TeamContest> teamContestList = teamContestService.getAllTeamContest();
        for (int i = 0; i < teamContestList.size(); i++) {
            Student student = studentService.findById(teamContestList.get(i).getStudent().getId());
            teamContestList.get(i).setStudent(student);
        }
        return teamContestList;
    }

    @PostMapping("/api/searchTeamContestById")
    public TeamContest findByTeamContestId(@RequestBody SearchByInt searchByInt) throws Exception {

        TeamContest teamContest = teamContestService.findById(searchByInt.getKeywords());
        Student student = studentService.findById(teamContest.getStudent().getId());
        teamContest.setStudent(student);
        return teamContest;
    }

    @PostMapping("/api/searchTeamContestByContestDetailId")
    public List<TeamContest> findByContestDetailId(@RequestBody SearchByInt searchByInt) throws Exception {

        List<TeamContest> teamContestList = teamContestService.findAllByContestDetail_Id(searchByInt.getKeywords());
        for (int i = 0; i < teamContestList.size(); i++) {
            Student student = studentService.findById(teamContestList.get(i).getStudent().getId());
            teamContestList.get(i).setStudent(student);
        }
        return teamContestList;
    }

    //有 student，没有 Organizer（在ContestDetail中）
    @PostMapping("/api/searchTeamContestByStudentAccount")
    public List<TeamContest> findAllByStudentAccount(@RequestBody Search s) throws Exception {

        List<TeamContest> teamContestList = teamContestService.findAllByStudent_User_Account(s.getKeywords());
        for (int i = 0; i < teamContestList.size(); i++) {
            ContestDetail contestDetail = contestDetailService.findById(teamContestList.get(i).getContestDetail().getId());
            teamContestList.get(i).setContestDetail(contestDetail);
        }
        return teamContestList;
    }

    //有 Organizer（在ContestDetail中） ，没有 student
    @PostMapping("/api/searchTeamContestByTeacherAccount")
    public List<TeamContest> findAllByTeacherAccount(@RequestBody Search s) throws Exception {

        List<TeamContest> teamContestList = teamContestService.findAllByTeacherAccount(s.getKeywords());
        for (int i = 0; i < teamContestList.size(); i++) {
            Student student = studentService.findById(teamContestList.get(i).getStudent().getId());
            teamContestList.get(i).setStudent(student);
        }
        return teamContestList;
    }

    //有 Organizer（在ContestDetail中） ，没有 student
    @PostMapping("/api/searchTeamContestByOrganizerAccount")
    public List<TeamContest> findAllByOrganizerAccount(@RequestBody Search s) throws Exception {

        List<TeamContest> teamContestList = teamContestService.findAllByContestDetail_Organizer_User_Account(s.getKeywords());
        for (int i = 0; i < teamContestList.size(); i++) {
            Student student = studentService.findById(teamContestList.get(i).getStudent().getId());
            teamContestList.get(i).setStudent(student);
        }
        return teamContestList;
    }

    //有 Organizer（在ContestDetail中） ，没有 student
    @PostMapping("/api/searchTeamContestByTeamName")
    public List<TeamContest> findAllByTeamName(@RequestBody Search s) throws Exception {

        List<TeamContest> teamContestList = teamContestService.findAllByTeamName(s.getKeywords());
        for (int i = 0; i < teamContestList.size(); i++) {
            Student student = studentService.findById(teamContestList.get(i).getStudent().getId());
            teamContestList.get(i).setStudent(student);
        }
        return teamContestList;
    }

    @PostMapping("/api/searchTeamContestByTeamNameAndContestDetailId")
    public List<TeamContest> findAllByTeamNameAndContestDetailId(@RequestBody SearchForTeamSignUp s) throws Exception {

        System.out.println("测试");
        System.out.println(s.getKeywords());
        System.out.println(s.getId());
        List<TeamContest> teamContestList = teamContestService.findAllByTeamNameAndContestDetail_Id(s.getKeywords(), s.getId());
        for (int i = 0; i < teamContestList.size(); i++) {
            Student student = studentService.findById(teamContestList.get(i).getStudent().getId());
            teamContestList.get(i).setStudent(student);
        }
        return teamContestList;
    }

//    //每一个报名的学生都会产生一个比赛记录，只是contest添加，但contestDetail不用添加
//    //当contestDetail删除记录时，contest里所有有关的比赛记录都要被删除
//    @PostMapping("/api/addTeamContest")
//    public TeamContest addContest(@RequestBody TeamContest teamContest) throws Exception {
//
//        boolean bl = teamContestService.isExist(teamContest.getId());
//        if (bl == true){
//            return null;
//        }else {
//
//            teamContest = teamContestService.addOrUpdateTeamContest(teamContest);
//
//            return teamContest;
//        }
//    }

//    //每一个报名的学生都会产生一个比赛记录，只是contest添加，但contestDetail不用添加
//    //当contestDetail删除记录时，contest里所有有关的比赛记录都要被删除
//    @PostMapping("/api/addTeamContest")
//    public TeamContestList addContest(@RequestBody TeamContestList teamContestList) throws Exception {
//
//        boolean bl = teamContestService.isExist(teamContestList.getId());
//        if (bl == true){
//            return null;
//        } else {
//            ContestDetail contestDetail = teamContestList.getContestDetail();
//            List<Student> studentList;
//            String teacherAccount = teamContestList.getTeacherAccount();
//            String teacherName = teamContestList.getTeacherName();
//            String state = teamContestList.getState();
//            String ticketNumber = teamContestList.getTicketNumber();
//            int score = teamContestList.getScore();
//            String teamName = teamContestList.getTeamName();
//            for (int i = 0; i < teamContestList.getStudentList().size(); i++) {
//                String remarks = "";
//                Student student = teamContestList.getStudentList().get(i);
//                if (teamContestList.getRemarksIndex() == i) {
//                    remarks = "队长";
//                }
//                TeamContest teamContest = new TeamContest();
//                teamContest.setId(0); // 在数据库中添加时会自动递增数字，这个 0 是没有什么作用的
//                teamContest.setContestDetail(contestDetail);
//                teamContest.setStudent(student);
//                teamContest.setTeacherAccount(teacherAccount);
//                teamContest.setTeacherName(teacherName);
//                teamContest.setState(state);
//                teamContest.setTicketNumber(ticketNumber);
//                teamContest.setScore(score);
//                teamContest.setTeamName(teamName);
//                teamContest.setRemarks(remarks);
//                teamContest = teamContestService.add(teamContest);
//            }
//
//            return teamContestList;
//        }
//    }
//
//    @PostMapping("/api/updateTeamContest")
//    public TeamContest updateTeamContest(@RequestBody TeamContest teamContest) throws Exception {
//
//        boolean bl = teamContestService.isExist(teamContest.getId());
//        if (bl == true){
//            teamContest = teamContestService.update(teamContest);
//            return teamContest;
//        }else {
//            return null;
//        }
//    }


    @PostMapping("/api/deleteTeamContest")
    public Result deleteTeamContest(@RequestBody TeamContest teamContestId) throws Exception {
        //因为前端只是传了一个 id 过来，所以 teacherId 里面只有一个 id 没有其他信息
        //所以要再通过 id 查询 teacher 的其他信息
        TeamContest teamContest = teamContestService.findById(teamContestId.getId());
        if (teamContest != null){
            teamContestService.deleteById(teamContestId.getId());
            //   删除成功返回码 100
            return new Result(100);
        } else {
            //   删除失败返回码 400
            return new Result(400);
        }
    }

    @PostMapping("/api/deleteTeam")
    public Result deleteTeam(@RequestBody Search s) throws Exception {
        //因为前端只是传了一个 id 过来，所以 teacherId 里面只有一个 id 没有其他信息
        //所以要再通过 id 查询 teacher 的其他信息
        List<TeamContest> teamContestList = teamContestService.findAllByTeamName(s.getKeywords());
        if (teamContestList != null){
            for (int i = 0; i < teamContestList.size(); i++) {
                teamContestService.deleteById(teamContestList.get(i).getId());
            }
            //   删除成功返回码 100
            return new Result(100);
        } else {
            //   删除失败返回码 400
            return new Result(400);
        }
    }

}

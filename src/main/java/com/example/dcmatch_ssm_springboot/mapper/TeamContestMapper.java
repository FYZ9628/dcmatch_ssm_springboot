package com.example.dcmatch_ssm_springboot.mapper;

import com.example.dcmatch_ssm_springboot.model.TeamContest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeamContestMapper {
    int add(TeamContest teamContest);

    int deleteById(int id);

    int update(TeamContest teamContest);

    List<TeamContest> getAllTeamContest();

    TeamContest findById(int id);

    List<TeamContest> findAllByContestDetail_Id(int id);

    List<TeamContest> findAllByStudent_User_Account(String account);

    List<TeamContest> findAllByTeacherAccount(String account);

    List<TeamContest> findAllByContestDetail_Organizer_User_Account(String account);

    List<TeamContest> findAllByTeamName(String teamName);

    //当有两个参数以上时要加 注解  @Param
    List<TeamContest> findAllByTeamNameAndContestDetail_Id(@Param("teamName") String teamName, @Param("contestDetailId") int contestDetailId);
}

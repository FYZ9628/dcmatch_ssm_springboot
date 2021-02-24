package com.example.dcmatch_ssm_springboot.service.impl;

import com.example.dcmatch_ssm_springboot.mapper.TeamContestMapper;
import com.example.dcmatch_ssm_springboot.model.TeamContest;
import com.example.dcmatch_ssm_springboot.service.TeamContestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamContestServiceImpl implements TeamContestService {

    @Autowired
    private TeamContestMapper teamContestMapper;

    @Override
    public int add(TeamContest teamContest) {
        return teamContestMapper.add(teamContest);
    }

    @Override
    public int deleteById(int id) {
        return teamContestMapper.deleteById(id);
    }

    @Override
    public int update(TeamContest teamContest) {
        return teamContestMapper.update(teamContest);
    }

    @Override
    public List<TeamContest> getAllTeamContest() {
        return teamContestMapper.getAllTeamContest();
    }

    @Override
    public TeamContest findById(int id) {
        return teamContestMapper.findById(id);
    }

    @Override
    public List<TeamContest> findAllByContestDetail_Id(int id) {
        return teamContestMapper.findAllByContestDetail_Id(id);
    }

    @Override
    public List<TeamContest> findAllByStudent_User_Account(String account) {
        return teamContestMapper.findAllByStudent_User_Account(account);
    }

    @Override
    public List<TeamContest> findAllByTeacherAccount(String account) {
        return teamContestMapper.findAllByTeacherAccount(account);
    }

    @Override
    public List<TeamContest> findAllByContestDetail_Organizer_User_Account(String account) {
        return teamContestMapper.findAllByContestDetail_Organizer_User_Account(account);
    }

    @Override
    public List<TeamContest> findAllByTeamName(String teamName) {
        return teamContestMapper.findAllByTeamName(teamName);
    }

    @Override
    public List<TeamContest> findAllByTeamNameAndContestDetail_Id(String teamName, int contestDetailId) {
        return teamContestMapper.findAllByTeamNameAndContestDetail_Id(teamName, contestDetailId);
    }

    @Override
    public boolean isExist(int id) {
        TeamContest teamContest = findById(id);
        return null != teamContest;
    }
}

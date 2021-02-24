package com.example.dcmatch_ssm_springboot.service.impl;

import com.example.dcmatch_ssm_springboot.mapper.ContestMapper;
import com.example.dcmatch_ssm_springboot.model.Contest;
import com.example.dcmatch_ssm_springboot.service.ContestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContestServiceImpl implements ContestService {

    @Autowired
    private ContestMapper contestMapper;

    @Override
    public int add(Contest contest) {
        return contestMapper.add(contest);
    }

    @Override
    public int deleteById(int id) {
        return contestMapper.deleteById(id);
    }

    @Override
    public int update(Contest contest) {
        return contestMapper.update(contest);
    }

    @Override
    public List<Contest> getAllContest() {
        return contestMapper.getAllContest();
    }

    @Override
    public Contest findById(int id) {
        return contestMapper.findById(id);
    }

    @Override
    public List<Contest> findAllByContestDetail_Id(int id) {
        return contestMapper.findAllByContestDetail_Id(id);
    }

    @Override
    public List<Contest> findAllByStudent_User_Account(String account) {
        return contestMapper.findAllByStudent_User_Account(account);
    }

    @Override
    public List<Contest> findAllByContestDetail_Organizer_User_Account(String account) {
        return contestMapper.findAllByContestDetail_Organizer_User_Account(account);
    }

    @Override
    public List<Contest> findAllByContestDetail_ContestTitleLikeOrContestDetail_Organizer_User_AccountLike(String keywords) {
        return contestMapper.findAllByContestDetail_ContestTitleLikeOrContestDetail_Organizer_User_AccountLike(keywords);
    }

    @Override
    public List<Contest> findAllByContestDetail_ContestTitleLikeOrStudent_User_AccountLike(String keywords) {
        return contestMapper.findAllByContestDetail_ContestTitleLikeOrStudent_User_AccountLike(keywords);
    }

    @Override
    public boolean isExist(int id) {
        Contest contest = findById(id);
        return null!=contest;
    }
}

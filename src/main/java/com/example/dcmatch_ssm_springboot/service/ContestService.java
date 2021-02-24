package com.example.dcmatch_ssm_springboot.service;

import com.example.dcmatch_ssm_springboot.model.Contest;

import java.util.List;

public interface ContestService {
    int add(Contest contest);

    int deleteById(int id);

    int update(Contest contest);

    List<Contest> getAllContest();

    Contest findById(int id);

    List<Contest> findAllByContestDetail_Id(int id);

    List<Contest> findAllByStudent_User_Account(String account);

    List<Contest> findAllByContestDetail_Organizer_User_Account(String account);

    List<Contest> findAllByContestDetail_ContestTitleLikeOrContestDetail_Organizer_User_AccountLike(String keywords);

    List<Contest> findAllByContestDetail_ContestTitleLikeOrStudent_User_AccountLike(String keywords);

    boolean isExist(int id);
}

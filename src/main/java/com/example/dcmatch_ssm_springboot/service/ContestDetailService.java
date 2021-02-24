package com.example.dcmatch_ssm_springboot.service;

import com.example.dcmatch_ssm_springboot.model.ContestDetail;

import java.util.List;

public interface ContestDetailService {
    int add(ContestDetail contestDetail);

    int deleteById(int id);

    int update(ContestDetail contestDetail);

    List<ContestDetail> getAllContestDetail();

    ContestDetail findById(int id);

    ContestDetail findByContestTitle(String contestTitle);

    List<ContestDetail> findAllByOrganizer_User_Account(String account);

    List<ContestDetail> findAllByContestTitleLikeOrOrganizer_User_NameLike(String keywords);

    boolean isExist(int id);
}

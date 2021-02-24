package com.example.dcmatch_ssm_springboot.service.impl;

import com.example.dcmatch_ssm_springboot.mapper.ContestDetailMapper;
import com.example.dcmatch_ssm_springboot.model.ContestDetail;
import com.example.dcmatch_ssm_springboot.service.ContestDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContestDetailServiceImpl implements ContestDetailService {

    @Autowired
    private ContestDetailMapper contestDetailMapper;

    @Override
    public int add(ContestDetail contestDetail) {
        return contestDetailMapper.add(contestDetail);
    }

    @Override
    public int deleteById(int id) {
        return contestDetailMapper.deleteById(id);
    }

    @Override
    public int update(ContestDetail contestDetail) {
        return contestDetailMapper.update(contestDetail);
    }

    @Override
    public List<ContestDetail> getAllContestDetail() {
        return contestDetailMapper.getAllContestDetail();
    }

    @Override
    public ContestDetail findById(int id) {
        return contestDetailMapper.findById(id);
    }

    @Override
    public ContestDetail findByContestTitle(String contestTitle) {
        return contestDetailMapper.findByContestTitle(contestTitle);
    }

    @Override
    public List<ContestDetail> findAllByOrganizer_User_Account(String account) {
        return contestDetailMapper.findAllByOrganizer_User_Account(account);
    }

    @Override
    public List<ContestDetail> findAllByContestTitleLikeOrOrganizer_User_NameLike(String keywords) {
        return contestDetailMapper.findAllByContestTitleLikeOrOrganizer_User_NameLike(keywords);
    }

    @Override
    public boolean isExist(int id) {
        ContestDetail contestDetail = findById(id);
        return null!=contestDetail;
    }
}

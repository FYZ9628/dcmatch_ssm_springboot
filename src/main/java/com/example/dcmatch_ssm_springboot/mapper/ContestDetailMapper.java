package com.example.dcmatch_ssm_springboot.mapper;

import com.example.dcmatch_ssm_springboot.model.ContestDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ContestDetailMapper {
    int add(ContestDetail contestDetail);

    int deleteById(int id);

    int update(ContestDetail contestDetail);

    List<ContestDetail> getAllContestDetail();

    ContestDetail findById(int id);

    ContestDetail findByContestTitle(String contestTitle);

    List<ContestDetail> findAllByOrganizer_User_Account(String account);

    List<ContestDetail> findAllByContestTitleLikeOrOrganizer_User_NameLike(String keywords);
}

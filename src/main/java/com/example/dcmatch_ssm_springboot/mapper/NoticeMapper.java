package com.example.dcmatch_ssm_springboot.mapper;

import com.example.dcmatch_ssm_springboot.model.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NoticeMapper {
    int add(Notice notice);

    int deleteById(int id);

    int update(Notice notice);

    List<Notice> getAllNotice();

    Notice findById(int id);

    List<Notice> findAllByTitleLike(String title);

    List<Notice> findAllByOrganizer_User_Account(String account);
}

package com.example.dcmatch_ssm_springboot.service;

import com.example.dcmatch_ssm_springboot.model.Notice;

import java.util.List;

public interface NoticeService {
    int add(Notice notice);

    int deleteById(int id);

    int update(Notice notice);

    List<Notice> getAllNotice();

    Notice findById(int id);

    List<Notice> findAllByTitleLike(String title);

    List<Notice> findAllByOrganizer_User_Account(String account);

    boolean isExist(int id);
}

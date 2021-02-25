package com.example.dcmatch_ssm_springboot.service.impl;

import com.example.dcmatch_ssm_springboot.mapper.NoticeMapper;
import com.example.dcmatch_ssm_springboot.model.Notice;
import com.example.dcmatch_ssm_springboot.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public int add(Notice notice) {
        return noticeMapper.add(notice);
    }

    @Override
    public int deleteById(int id) {
        return noticeMapper.deleteById(id);
    }

    @Override
    public int update(Notice notice) {
        return noticeMapper.update(notice);
    }

    @Override
    public List<Notice> getAllNotice() {
        return noticeMapper.getAllNotice();
    }

    @Override
    public Notice findById(int id) {
        return noticeMapper.findById(id);
    }

    @Override
    public List<Notice> findAllByTitleLike(String title) {
        return noticeMapper.findAllByTitleLike(title);
    }

    @Override
    public List<Notice> findAllByOrganizer_User_Account(String account) {
        return noticeMapper.findAllByOrganizer_User_Account(account);
    }

    @Override
    public boolean isExist(int id) {
        Notice notice = findById(id);
        return null!=notice;
    }
}

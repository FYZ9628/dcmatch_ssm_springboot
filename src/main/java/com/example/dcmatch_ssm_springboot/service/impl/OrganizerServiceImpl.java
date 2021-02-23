package com.example.dcmatch_ssm_springboot.service.impl;

import com.example.dcmatch_ssm_springboot.mapper.OrganizerMapper;
import com.example.dcmatch_ssm_springboot.model.Organizer;
import com.example.dcmatch_ssm_springboot.service.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizerServiceImpl implements OrganizerService {

    @Autowired
    private OrganizerMapper organizerMapper;

    @Override
    public int add(Organizer teacher) {
        return organizerMapper.add(teacher);
    }

    @Override
    public int deleteById(int id) {
        return organizerMapper.deleteById(id);
    }

    @Override
    public int update(Organizer organizer) {
        return organizerMapper.update(organizer);
    }

    @Override
    public List<Organizer> getAllOrganizer() {
        return organizerMapper.getAllOrganizer();
    }

    @Override
    public Organizer findById(int id) {
        return organizerMapper.findById(id);
    }

    @Override
    public Organizer findByUser_Account(String account) {
        return organizerMapper.findByUser_Account(account);
    }

    @Override
    public List<Organizer> findAllByUser_NameLikeOrUser_AccountLike(String keywords) {
        return organizerMapper.findAllByUser_NameLikeOrUser_AccountLike(keywords);
    }
}

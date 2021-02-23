package com.example.dcmatch_ssm_springboot.service;

import com.example.dcmatch_ssm_springboot.model.Organizer;

import java.util.List;

public interface OrganizerService {
    int add(Organizer organizer);

    int deleteById(int id);

    int update(Organizer organizer);

    List<Organizer> getAllOrganizer();

    Organizer findById(int id);

    Organizer findByUser_Account(String account);

    List<Organizer> findAllByUser_NameLikeOrUser_AccountLike(String keywords);
}

package com.example.dcmatch_ssm_springboot.mapper;

import com.example.dcmatch_ssm_springboot.model.Organizer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrganizerMapper {
    int add(Organizer organizer);

    int deleteById(int id);

    int update(Organizer organizer);

    List<Organizer> getAllOrganizer();

    Organizer findById(int id);

    Organizer findByUser_Account(String account);

    List<Organizer> findAllByUser_NameLikeOrUser_AccountLike(String keywords);
}

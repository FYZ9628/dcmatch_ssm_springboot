package com.example.dcmatch_ssm_springboot.service;

import com.example.dcmatch_ssm_springboot.model.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerService {
    //增加
    int add(Banner banner);

    //根据id删除
    int deleteById(int id);

    //根据id更新信息
    int update(Banner banner);

    //查询全部，返回list集合
    List<Banner> getAllBanner();

    //根据名称查询,返回一个对象
    Banner findBannerByName(String name);

    //根据id查询,返回一个对象
    Banner findBannerById(int id);

    //根据名称查询,返回所有
    List<Banner> findAllByNameLike(String name);

    boolean isExist(int id);
}

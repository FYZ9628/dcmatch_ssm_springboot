package com.example.dcmatch_ssm_springboot.service.impl;

import com.example.dcmatch_ssm_springboot.mapper.BannerMapper;
import com.example.dcmatch_ssm_springboot.model.Banner;
import com.example.dcmatch_ssm_springboot.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public int add(Banner banner) {
        return bannerMapper.add(banner);
    }

    @Override
    public int deleteById(int id) {
        return bannerMapper.deleteById(id);
    }

    @Override
    public int update(Banner banner) {
        return bannerMapper.update(banner);
    }

    @Override
    public List<Banner> getAllBanner() {
        return bannerMapper.getAllBanner();
    }

    @Override
    public Banner findBannerByName(String name) {
        return bannerMapper.findBannerByName(name);
    }

    @Override
    public Banner findBannerById(int id) {
        return bannerMapper.findBannerById(id);
    }

    @Override
    public List<Banner> findAllByNameLike(String name) {
        return bannerMapper.findAllByNameLike(name);
    }

    @Override
    public boolean isExist(int id) {
        Banner banner = findBannerById(id);
        return null!= banner;
    }
}

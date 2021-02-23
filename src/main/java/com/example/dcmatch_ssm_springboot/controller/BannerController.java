package com.example.dcmatch_ssm_springboot.controller;

import com.example.dcmatch_ssm_springboot.model.Banner;
import com.example.dcmatch_ssm_springboot.result.Result;
import com.example.dcmatch_ssm_springboot.result.Search;
import com.example.dcmatch_ssm_springboot.result.SearchByInt;
import com.example.dcmatch_ssm_springboot.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @PostMapping("/api/addBanner")
    public Banner addBanner(@RequestBody Banner banner) throws Exception {

        boolean bl = bannerService.isExist(banner.getId());
        if (bl == true){
            return null;
        }else {
            bannerService.add(banner);
            Banner banner1 = bannerService.findBannerByName(banner.getName());
            return banner1;
        }
    }

    //修改
    @PostMapping("/api/updateBanner")
    public Banner updateStudent(@RequestBody Banner banner) throws Exception {

        boolean bl = bannerService.isExist(banner.getId());
        if (bl == true){
            bannerService.update(banner);
            Banner banner1 = bannerService.findBannerById(banner.getId());
            return banner1;
        }else {
            return null;
        }
    }

    //删除
    @PostMapping("/api/deleteBanner")
    public Result deleteStudent(@RequestBody Banner bannerId) throws Exception {
        //因为前端只是传了一个 id 过来，所以 teacherId 里面只有一个 id 没有其他信息
        //所以要再通过 id 查询 teacher 的其他信息
        Banner banner = bannerService.findBannerById(bannerId.getId());
        if (banner != null){
            bannerService.deleteById(bannerId.getId());
            //   删除成功返回码 100
            return new Result(100);
        } else {
            //   删除失败返回码 400
            return new Result(400);
        }
    }

    @GetMapping("/api/getAllBanner")
    public List<Banner> getAllBanner() {
        List<Banner> bannerList = bannerService.getAllBanner();
        return bannerList;
    }

    @PostMapping("/api/findAllByNameLike")
    public List<Banner> findAllByNameLike(@RequestBody Search s) throws Exception {

        List<Banner> bannerList = bannerService.findAllByNameLike(s.getKeywords());
        return bannerList;
    }


    @PostMapping("/api/findBannerByName")
    public Banner findBannerByName(@RequestBody Search s) throws Exception {

        return bannerService.findBannerByName(s.getKeywords());
    }

    @PostMapping("/api/findBannerById")
    public Banner findBannerById(@RequestBody SearchByInt searchByInt) throws Exception {

        return bannerService.findBannerById(searchByInt.getKeywords());
    }
}

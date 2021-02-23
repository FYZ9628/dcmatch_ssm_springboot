package com.example.dcmatch_ssm_springboot.mapper;

import com.example.dcmatch_ssm_springboot.model.Banner;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BannerMapper {
    //增加
    int add(Banner banner);

    //根据id删除
    int deleteById(@Param("id") int id);

    //根据id更新信息
    int update(Banner banner);

    //查询全部，返回list集合
    List<Banner> getAllBanner();

    //精确查询
    //根据名称查询,返回一个对象
    Banner findBannerByName(@Param("name") String name);

    //精确查询
    //根据id查询,返回一个对象
    Banner findBannerById(@Param("id") int id);

    //模糊查询
    //根据名称查询,返回所有
    List<Banner> findAllByNameLike(@Param("name") String name);
}

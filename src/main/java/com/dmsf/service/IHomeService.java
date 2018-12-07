package com.dmsf.service;

import com.dmsf.domain.Video;

import java.util.List;

/**
 * @Auther: LiPan
 * @Date: 2018.12.3 15:55
 * @Description:service类 用于操作影视库
 */
public interface IHomeService {


    //查询当前页数据
     List<Video> listPage();


    List<Video> hotMovie();

    List<Video> hotTelevision();

    List<Video> hotAnimation();

    List<Video> hot3ForAll();
}

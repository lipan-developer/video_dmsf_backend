package com.dmsf.service;

import com.dmsf.domain.DmsfVideoInfo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Auther: LiPan
 * @Date: 2018.12.3 15:55
 * @Description:service类 用于操作影视库
 */
public interface IHomeService {


    //查询当前页数据
    Page<DmsfVideoInfo> listPage(Integer page, Integer size);


    List<DmsfVideoInfo> hotMovie();

    List<DmsfVideoInfo> hotTelevision();

    List<DmsfVideoInfo> hotAnimation();

    List<DmsfVideoInfo> hot3ForAll();
}

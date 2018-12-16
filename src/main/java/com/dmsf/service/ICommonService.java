package com.dmsf.service;

import com.dmsf.domain.Video;
import com.dmsf.model.resp.NavDataResp;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Auther: LiPan
 * @Date: 2018.12.14 11:18
 * @Description:
 */
public interface ICommonService {
    Page<Video> getSeachResult(String value, String searchValue, Integer page, Integer size);

//    List<Video> getSeachResult(String searchValue, String type);
}

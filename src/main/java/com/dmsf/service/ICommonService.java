package com.dmsf.service;

import com.dmsf.domain.Video;
import com.dmsf.model.resp.NavDataResp;

import java.util.List;

/**
 * @Auther: LiPan
 * @Date: 2018.12.14 11:18
 * @Description:
 */
public interface ICommonService {
    NavDataResp getSeachResult(String searchValue);

    List<Video> getSeachResult(String searchValue, String type);
}

package com.dmsf.service;

import com.dmsf.domain.DmsfVideoInfo;

/**
 * @Auther: LiPan
 * @Date: 2018.12.6 11:23
 * @Description:
 */
public interface IDetailsService {
    DmsfVideoInfo getVideoDetail(String tableKey);
}

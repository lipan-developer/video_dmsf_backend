package com.dmsf.service;

import com.dmsf.domain.Video;

/**
 * @Auther: LiPan
 * @Date: 2018.12.6 11:23
 * @Description:
 */
public interface IDetailsService {
    Video getVideoDetail(String tableKey);
}

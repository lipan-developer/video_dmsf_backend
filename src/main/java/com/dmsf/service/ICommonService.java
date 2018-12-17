package com.dmsf.service;

import com.dmsf.domain.DmsfVideoInfo;
import org.springframework.data.domain.Page;

/**
 * @Auther: LiPan
 * @Date: 2018.12.14 11:18
 * @Description:
 */
public interface ICommonService {
    Page<DmsfVideoInfo> getSeachResult(String value, String searchValue, Integer page, Integer size);

//    List<DmsfVideoInfo> getSeachResult(String searchValue, String type);
}

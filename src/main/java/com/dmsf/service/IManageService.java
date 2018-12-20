package com.dmsf.service;

import com.dmsf.domain.DmsfVideoInfo;
import com.dmsf.model.req.ManagePageReq;
import org.springframework.data.domain.Page;

/**
 * @Auther: LiPan
 * @Date: 2018.12.20 16:49
 * @Description:
 */
public interface IManageService {
    Page<DmsfVideoInfo> listPage(ManagePageReq req);
}

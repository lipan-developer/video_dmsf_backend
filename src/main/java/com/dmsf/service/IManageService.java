package com.dmsf.service;

import com.dmsf.domain.DmsfVideoInfo;
import com.dmsf.domain.VideoSalveInfo;
import com.dmsf.model.req.ManagePageReq;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * @Auther: LiPan
 * @Date: 2018.12.20 16:49
 * @Description:
 */
public interface IManageService {
    Page<DmsfVideoInfo> listPage(ManagePageReq req);

    Boolean editData(DmsfVideoInfo video);

    Boolean deleteData(String tableKey);

    Boolean addManageDetails(Map<String,String> req);

    Boolean deleteManageDetails(String tableKey);

    Page<VideoSalveInfo> queryManageDetails(Map req);
}

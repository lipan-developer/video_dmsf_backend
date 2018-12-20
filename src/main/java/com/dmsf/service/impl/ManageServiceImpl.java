package com.dmsf.service.impl;

import com.dmsf.domain.DmsfVideoInfo;
import com.dmsf.model.req.ManagePageReq;
import com.dmsf.repositoty.VideoRepository;
import com.dmsf.service.IManageService;
import com.dmsf.util.VideoType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @Auther: LiPan
 * @Date: 2018.12.20 16:50
 * @Description:
 */
@Service
public class ManageServiceImpl implements IManageService {

    @Autowired
    private VideoRepository videoRepository;

    @Override
    public Page<DmsfVideoInfo> listPage(ManagePageReq req) {
        //判断排序类型及排序字段
        Sort sort =  new Sort(Sort.Direction.DESC, "updateTime");
        //获取pageable
        Pageable pageable = new PageRequest(req.getPage()-1,req.getSize(),sort);
        if (StringUtils.isBlank(req.getTitle())) req.setTitle("");
        if (StringUtils.isBlank(req.getActor())) req.setActor("");
        if (StringUtils.isBlank(req.getType())) req.setType("0");

        if (req.getType().equals(VideoType.VIDEO_ALL)){
            Page<DmsfVideoInfo> allLikeVideos = videoRepository.findByTitleLikeAndActorLike("%" + req.getTitle() + "%","%" + req.getActor() + "%",pageable);
            return  allLikeVideos;
        }else{
            Page<DmsfVideoInfo> likeVideos = videoRepository.findByTypeAndTitleLikeAndActorLike(req.getType(),"%" + req.getTitle() + "%","%" + req.getActor() + "%",pageable);
            return  likeVideos;
        }
    }
}

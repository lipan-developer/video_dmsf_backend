package com.dmsf.service.impl;

import com.dmsf.domain.DmsfVideoInfo;
import com.dmsf.domain.VideoSalveInfo;
import com.dmsf.exception.ReturnException;
import com.dmsf.model.req.ManagePageReq;
import com.dmsf.repositoty.VideoRepository;
import com.dmsf.repositoty.VideoSalveRepository;
import com.dmsf.service.IManageService;
import com.dmsf.util.CommonUtils;
import com.dmsf.util.VideoType;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Auther: LiPan
 * @Date: 2018.12.20 16:50
 * @Description:
 */
@Service
public class ManageServiceImpl implements IManageService {

    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private VideoSalveRepository videoSalveRepository;
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

    @Override
    public Boolean editData(DmsfVideoInfo video) {
        validateParams(video);
    if (StringUtils.isBlank(video.getTableKey())){
        //new
        video.setCreateUser(video.getUpdateUser());
        video.setCreateTime(new Date());
        video.setSupport(0);
        video.setUpdateTime(new Date());
        if (video.getDescribeInfo().length()>30){
            String small = video.getDescribeInfo().substring(0,30);
            video.setSmallDescible(small+"...");
        }else{
            video.setSmallDescible(video.getDescribeInfo()+"...");
        }
        video.setTableKey(CommonUtils.randomUUID());
        videoRepository.save(video);
    }else{
        DmsfVideoInfo videoInfo = videoRepository.findByTableKey(video.getTableKey());
        if(video.getDescribeInfo().length()>30){
            String small = video.getDescribeInfo().substring(0,30);
            videoInfo.setSmallDescible(small+"...");
        }else{
            videoInfo.setSmallDescible(video.getDescribeInfo()+"...");
        }
        videoInfo.setUpdateTime(new Date());
        videoInfo.setActor(video.getActor());
        videoInfo.setDescribeInfo(video.getDescribeInfo());
        videoInfo.setTitle(video.getTitle());
        videoInfo.setType(video.getType());
        videoInfo.setShowTime(video.getShowTime());
        videoInfo.setPicture(video.getPicture());
        videoInfo.setUpdateUser(video.getUpdateUser());
        videoRepository.save(videoInfo);
    }

        return  true;
    }

    @Override
    public Boolean deleteData(String tableKey) {
        DmsfVideoInfo video = videoRepository.findByTableKey(tableKey);
        if (null!=video) videoRepository.delete(video);
        List<VideoSalveInfo> salves = videoSalveRepository.findByMasterKey(tableKey);
        if (null!=salves&&salves.size()>0) videoSalveRepository.deleteAll(salves);
        return true;
    }

    @Override
    public Boolean addManageDetails(Map<String,String> req) {
        String masterKey = req.get("masterKey");
        String tableKey = req.get("tableKey");
        String url = req.get("url");
        String remark = req.get("remark");
        String episodeNumber = req.get("episodeNumber");
        validateSomeParams(masterKey,url,episodeNumber);
        if (StringUtils.isBlank(tableKey)){
            VideoSalveInfo videoSalveInfo = new VideoSalveInfo();
            videoSalveInfo.setTableKey(CommonUtils.randomUUID());
            videoSalveInfo.setEpisodeNumber(episodeNumber);
            videoSalveInfo.setMasterKey(masterKey);
            videoSalveInfo.setRemark(remark);
            videoSalveInfo.setUrl(url);
            videoSalveRepository.save(videoSalveInfo);
        }else{
            VideoSalveInfo video = videoSalveRepository.findByTableKey(tableKey);
            video.setUrl(url);
            video.setRemark(remark);
            video.setEpisodeNumber(episodeNumber);
            videoSalveRepository.save(video);
        }
        return true;
    }

    private void validateSomeParams(String masterKey, String url, String episodeNumber) {
        if (StringUtils.isBlank(masterKey)) throw new ReturnException("masterKey不能为空！");
        if (StringUtils.isBlank(url)) throw new ReturnException("url地址不能为空！");
        if (StringUtils.isBlank(episodeNumber)) throw new ReturnException("集数不能为空！");
    }

    @Override
    public Boolean deleteManageDetails(String tableKey) {
        VideoSalveInfo video =  videoSalveRepository.findByTableKey(tableKey);
        if (null!=video) videoSalveRepository.delete(video);
        return true;
    }

    @Override
    public Page<VideoSalveInfo> queryManageDetails(Map req) {
        Integer page = (Integer)req.get("page");
        Integer size = (Integer)req.get("size");
        String masterKey = (String)req.get("masterKey");
        //获取pageable
        Pageable pageable = new PageRequest(page - 1,size);
        Page<VideoSalveInfo> videoSalveInfos =videoSalveRepository.findByMasterKey(masterKey,pageable);
        return videoSalveInfos;

    }

    private void validateParams(DmsfVideoInfo video) {
        if (StringUtils.isBlank(video.getActor())) throw new ReturnException("演员不能为空！");
        if (StringUtils.isBlank(video.getUpdateUser())) throw new ReturnException("创建人不能为空！");
        if (StringUtils.isBlank(video.getDescribeInfo())) throw new ReturnException("描述信息不能为空！");
        if (StringUtils.isBlank(video.getPicture())) throw new ReturnException("图片路径不能为空！");
        if (StringUtils.isBlank(video.getType())) throw new ReturnException("类型不能为空！");
        if (null == video.getShowTime()) throw new ReturnException("上映时间不能为空！");
    }
}

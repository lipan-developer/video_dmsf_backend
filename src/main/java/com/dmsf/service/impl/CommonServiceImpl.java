package com.dmsf.service.impl;

import com.dmsf.domain.Video;
import com.dmsf.model.resp.NavDataResp;
import com.dmsf.repositoty.VideoRepository;
import com.dmsf.service.ICommonService;
import com.dmsf.util.VideoType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: LiPan
 * @Date: 2018.12.14 11:18
 * @Description:
 */
@Service
public class CommonServiceImpl implements ICommonService {

    @Autowired
    private VideoRepository videoRepository;

//    @Override
//    public NavDataResp getSeachResult(String searchValue) {
//        List<Video> videos = videoRepository.findByTitleLike("%"+searchValue+"%");
//        if (videos.size() == 0) return  null;
//        NavDataResp nav = new NavDataResp();
//        for (int i = 0; i < videos.size(); i++) {
//            if (i == 0) {
//                nav.setType(videos.get(0).getType());
//                continue;
//            }
//            if (!nav.getType().equals(videos.get(i).getType())){
//                nav.setType(VideoType.VIDEO_ALL);
//            }
//        }
//        nav.setData(videos);
//        return nav;
//    }

    @Override
    public Page<Video> getSeachResult(String searchValue, String type, Integer page, Integer size){
        //判断排序类型及排序字段
        Sort sort =  new Sort(Sort.Direction.DESC, "updateTime");
        //获取pageable
        Pageable pageable = new PageRequest(page-1,size,sort);
        if (type.equals(VideoType.VIDEO_ALL)){
            Page<Video> allLikeVideos = videoRepository.findByTitleLike("%" + searchValue + "%",pageable);
            return  allLikeVideos;
        }else{
            Page<Video> likeVideos = videoRepository.findByTypeAndTitleLike(type,"%" + searchValue + "%",pageable);
            return  likeVideos;
        }
    }

//    @Override
//    public List<Video> getSeachResult(String searchValue, String type) {
//        if (type.equals(VideoType.VIDEO_ALL)){
//            List<Video> allLikeVideos = videoRepository.findByTitleLike("%" + searchValue + "%");
//            return  allLikeVideos;
//        }else{
//            List<Video> likeVideos = videoRepository.findByTypeAndTitleLike(type,"%" + searchValue + "%");
//            return  likeVideos;
//        }
//
//    }
}

package com.dmsf.service.impl;

import com.dmsf.domain.DmsfVideoInfo;
import com.dmsf.repositoty.VideoRepository;
import com.dmsf.service.IHomeService;
import com.dmsf.util.VideoType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: LiPan
 * @Date: 2018.12.3 16:02
 * @Description: IVideoService实现类
 */
@Service
public class HomeServiceImpl implements IHomeService {


    @Autowired
    private VideoRepository videoRepository;


    @Override
    public Page<DmsfVideoInfo> listPage(Integer page, Integer size) {
        //判断排序类型及排序字段
        Sort sort =  new Sort(Sort.Direction.DESC, "updateTime");
        //获取pageable
        Pageable pageable = new PageRequest(page-1,size,sort);
        Page<DmsfVideoInfo> all = videoRepository.findAll(pageable);
        return  all;
    }

    @Override
    public List<DmsfVideoInfo> hotMovie() {
        return getSupportFirst10ByType(VideoType.VIDEO_MOVIE);
    }

    private List<DmsfVideoInfo> getSupportFirst10ByType(String type) {
        Sort sort = new Sort(Sort.Direction.DESC, "support");
        return videoRepository.findFirst10ByType(type,sort);
    }

    @Override
    public List<DmsfVideoInfo> hotTelevision() {
        return getSupportFirst10ByType(VideoType.VIDEO_TELEVISON);
    }

    @Override
    public List<DmsfVideoInfo> hotAnimation() {
        return getSupportFirst10ByType(VideoType.VIDEO_ANIMATION);
    }

    @Override
    public List<DmsfVideoInfo> hot3ForAll() {
        List<DmsfVideoInfo> list = new ArrayList<>();
        List<DmsfVideoInfo> hotMovies = hotMovie();
        List<DmsfVideoInfo> hotTelevisions = hotTelevision();
        List<DmsfVideoInfo> hotAnimations = hotAnimation();
        list.add(hotMovies.get(0));
        list.add(hotTelevisions.get(0));
        list.add(hotAnimations.get(0));
        return list;
    }
}

package com.dmsf.service.impl;

import com.dmsf.domain.Video;
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
    public Page<Video> listPage(Integer page,Integer size) {
        //判断排序类型及排序字段
        Sort sort =  new Sort(Sort.Direction.DESC, "updateTime");
        //获取pageable
        Pageable pageable = new PageRequest(page-1,size,sort);
        Page<Video> all = videoRepository.findAll(pageable);
        return  all;
    }

    @Override
    public List<Video> hotMovie() {
        return getSupportFirst10ByType(VideoType.VIDEO_MOVIE);
    }

    private List<Video> getSupportFirst10ByType(String type) {
        Sort sort = new Sort(Sort.Direction.DESC, "support");
        return videoRepository.findFirst10ByType(type,sort);
    }

    @Override
    public List<Video> hotTelevision() {
        return getSupportFirst10ByType(VideoType.VIDEO_TELEVISON);
    }

    @Override
    public List<Video> hotAnimation() {
        return getSupportFirst10ByType(VideoType.VIDEO_ANIMATION);
    }

    @Override
    public List<Video> hot3ForAll() {
        List<Video> list = new ArrayList<>();
        List<Video> hotMovies = hotMovie();
        List<Video> hotTelevisions = hotTelevision();
        List<Video> hotAnimations = hotAnimation();
        list.add(hotMovies.get(0));
        list.add(hotTelevisions.get(0));
        list.add(hotAnimations.get(0));
        return list;
    }
}

package com.dmsf.service.impl;

import com.dmsf.domain.Video;
import com.dmsf.repositoty.VideoRepository;
import com.dmsf.service.IAnimationService;
import com.dmsf.util.VideoType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: LiPan
 * @Date: 2018.12.3 16:02
 * @Description: IVideoService实现类
 */
@Service
public class AnimationServiceImpl implements IAnimationService {


    @Autowired
    private VideoRepository videoRepository;


    @Override
    public List<Video> listPage() {
        return videoRepository.findByType(VideoType.VIDEO_ANIMATION);

    }

    @Override
    public List<Video> getNewAnimation() {
        return getFirst10ByType(VideoType.VIDEO_ANIMATION,"updateTime");
    }

    @Override
    public List<Video> getHotAnimation() {
        return getFirst10ByType(VideoType.VIDEO_ANIMATION,"support");
    }

    private List<Video> getFirst10ByType(String type,String sortType) {
        Sort sort = new Sort(Sort.Direction.DESC, sortType);
        return videoRepository.findFirst10ByType(type,sort);
    }
}

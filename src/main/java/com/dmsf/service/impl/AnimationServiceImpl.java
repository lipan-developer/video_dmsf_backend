package com.dmsf.service.impl;

import com.dmsf.domain.Video;
import com.dmsf.repositoty.VideoRepository;
import com.dmsf.service.IAnimationService;
import com.dmsf.util.VideoType;
import org.springframework.beans.factory.annotation.Autowired;
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
}

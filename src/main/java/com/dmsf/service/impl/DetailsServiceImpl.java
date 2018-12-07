package com.dmsf.service.impl;

import com.dmsf.domain.Video;
import com.dmsf.repositoty.VideoRepository;
import com.dmsf.service.IDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: LiPan
 * @Date: 2018.12.6 11:24
 * @Description:
 */
@Service
public class DetailsServiceImpl implements IDetailsService{

    @Autowired
    private VideoRepository videoRepository;


    @Override
    public Video getVideoDetail(String tableKey) {
        return videoRepository.findByTableKey(tableKey);
    }

}

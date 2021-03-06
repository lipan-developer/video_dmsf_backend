package com.dmsf.service.impl;

import com.dmsf.domain.DmsfVideoInfo;
import com.dmsf.domain.VideoSalveInfo;
import com.dmsf.repositoty.VideoRepository;
import com.dmsf.repositoty.VideoSalveRepository;
import com.dmsf.service.IDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: LiPan
 * @Date: 2018.12.6 11:24
 * @Description:
 */
@Service
public class DetailsServiceImpl implements IDetailsService{

    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private VideoSalveRepository salveRepository;

    @Override
    public DmsfVideoInfo getVideoDetail(String tableKey) {
        DmsfVideoInfo master = videoRepository.findByTableKey(tableKey);
        List<VideoSalveInfo> salves = salveRepository.findByMasterKey(tableKey);
        master.setSalves(salves);
        return master;
    }

}

package com.dmsf.service.impl;

import com.dmsf.domain.DmsfVideoInfo;
import com.dmsf.repositoty.VideoRepository;
import com.dmsf.service.ITelevisionService;
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
 * @Date: 2018.12.3 16:02
 * @Description: IVideoService实现类
 */
@Service
public class TelevisionServiceImpl implements ITelevisionService {


    @Autowired
    private VideoRepository videoRepository;


    @Override
    public Page<DmsfVideoInfo> listPage(Integer page, Integer size) {
        //判断排序类型及排序字段
        Sort sort =  new Sort(Sort.Direction.DESC, "updateTime");
        //获取pageable
        Pageable pageable = new PageRequest(page-1,size,sort);
        Page<DmsfVideoInfo> all = videoRepository.findByType(VideoType.VIDEO_TELEVISON,pageable);
        return  all;
    }

    @Override
    public List<DmsfVideoInfo> getNewTelvision() {
        return getFirst10ByType(VideoType.VIDEO_TELEVISON,"updateTime");
    }

    @Override
    public List<DmsfVideoInfo> getHotTelvision() {
        return getFirst10ByType(VideoType.VIDEO_TELEVISON,"support");
    }

    private List<DmsfVideoInfo> getFirst10ByType(String type, String sortType) {
        Sort sort = new Sort(Sort.Direction.DESC,sortType );
        return videoRepository.findFirst10ByType(type,sort);
    }
}

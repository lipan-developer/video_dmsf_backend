package com.dmsf.service.impl;

import com.dmsf.domain.Video;
import com.dmsf.repositoty.VideoRepository;
import com.dmsf.service.IHomeService;
import com.dmsf.service.ITelevisionService;
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
public class TelevisionServiceImpl implements ITelevisionService {


    @Autowired
    private VideoRepository videoRepository;


    @Override
    public List<Video> listPage() {
        return videoRepository.findByType(VideoType.VIDEO_TELEVISON);
    }

    @Override
    public List<Video> getNewTelvision() {
        return getFirst10ByType(VideoType.VIDEO_TELEVISON,"updateTime");
    }

    @Override
    public List<Video> getHotTelvision() {
        return getFirst10ByType(VideoType.VIDEO_TELEVISON,"support");
    }

    private List<Video> getFirst10ByType(String type,String sortType) {
        Sort sort = new Sort(Sort.Direction.DESC,sortType );
        return videoRepository.findFirst10ByType(type,sort);
    }
}

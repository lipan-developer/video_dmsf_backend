package com.dmsf.service;

import com.dmsf.domain.Video;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Auther: LiPan
 * @Date: 2018.12.3 15:55
 * @Description:service类 用于操作影视库
 */
public interface IMovieService {




    List<Video> getNewMovie();

    List<Video> getHotMovie();

    Page<Video> listPage(Integer page, Integer size);
}

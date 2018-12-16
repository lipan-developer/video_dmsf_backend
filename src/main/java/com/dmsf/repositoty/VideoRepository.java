package com.dmsf.repositoty;


import com.dmsf.domain.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: LiPan
 * @Date: 2018.12.3 16:04
 * @Description:
 */
@Repository
public interface VideoRepository extends JpaRepository<Video, String> {
    List<Video> findByType(String type);

    Video findByTableKey(String tableKey);

    List<Video> findFirst10ByType(String videoMovie, Sort sort);

    List<Video> findByTitleLike(String title);

    List<Video> findByTypeAndTitleLike(String type, String title);

    Page<Video> findByType(String videoMovie, Pageable pageable);

    Page<Video> findByTitleLike(String s, Pageable pageable);

    Page<Video> findByTypeAndTitleLike(String type, String s, Pageable pageable);
}

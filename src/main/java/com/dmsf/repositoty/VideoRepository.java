package com.dmsf.repositoty;


import com.dmsf.domain.Video;
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
}

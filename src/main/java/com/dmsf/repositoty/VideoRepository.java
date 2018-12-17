package com.dmsf.repositoty;


import com.dmsf.domain.DmsfVideoInfo;
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
public interface VideoRepository extends JpaRepository<DmsfVideoInfo, String> {
    List<DmsfVideoInfo> findByType(String type);

    DmsfVideoInfo findByTableKey(String tableKey);

    List<DmsfVideoInfo> findFirst10ByType(String videoMovie, Sort sort);

    List<DmsfVideoInfo> findByTitleLike(String title);

    List<DmsfVideoInfo> findByTypeAndTitleLike(String type, String title);

    Page<DmsfVideoInfo> findByType(String videoMovie, Pageable pageable);

    Page<DmsfVideoInfo> findByTitleLike(String s, Pageable pageable);

    Page<DmsfVideoInfo> findByTypeAndTitleLike(String type, String s, Pageable pageable);
}

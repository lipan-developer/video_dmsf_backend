package com.dmsf.repositoty;


import com.dmsf.domain.DmsfVideoInfo;
import com.dmsf.domain.VideoSalveInfo;
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
public interface VideoSalveRepository extends JpaRepository<VideoSalveInfo, String> {

    List<VideoSalveInfo> findByMasterKey(String tableKey);
}

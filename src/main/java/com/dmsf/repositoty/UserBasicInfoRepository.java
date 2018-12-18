package com.dmsf.repositoty;


import com.dmsf.domain.UserBasicInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Auther: LiPan
 * @Date: 2018.12.3 16:04
 * @Description:
 */
@Repository
public interface UserBasicInfoRepository extends JpaRepository<UserBasicInfo, String> {

    UserBasicInfo findByNickNameAndPassword(String nickName, String password);

    UserBasicInfo findByTableKey(String tableKey);
}

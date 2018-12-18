package com.dmsf.service;

import com.dmsf.domain.UserBasicInfo;

/**
 * @Auther: LiPan
 * @Date: 2018.12.18 10:34
 * @Description:
 */
public interface IUserService {
    UserBasicInfo getUser(String nickName, String password);

    void editUser(UserBasicInfo user);
}

package com.dmsf.service.impl;

import com.dmsf.domain.UserBasicInfo;
import com.dmsf.exception.ReturnException;
import com.dmsf.repositoty.UserBasicInfoRepository;
import com.dmsf.service.IUserService;
import com.dmsf.util.CommonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.regex.Pattern;

/**
 * @Auther: LiPan
 * @Date: 2018.12.18 10:35
 * @Description:
 */
@Service
public class UserServiceImpl implements IUserService {

    public static final String REGEX_MOBILE = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";

    @Autowired
    private UserBasicInfoRepository userBasicInfoRepository;

    @Override
    public UserBasicInfo getUser(String nickName, String password) {
        UserBasicInfo user = userBasicInfoRepository.findByNickNameAndPassword(nickName, password);
        if (null==user) throw new ReturnException("当前账号不存在！");
        return user;
    }

    @Override
    public void editUser(UserBasicInfo user) {
        //验证参数
        if(!user.getPassword().equals(user.getRepeatPassword())) throw new ReturnException("密码和确认密码必须一致！");
        if( !Pattern.matches(REGEX_MOBILE, user.getPhone()))  throw new ReturnException("手机号输入不正确！");
        if (StringUtils.isBlank(user.getNickName()))  throw new ReturnException("昵称不能为空！");
        if (StringUtils.isBlank(user.getPassword()))  throw new ReturnException("密码不能为空！");

        if(StringUtils.isBlank(user.getTableKey())){
            user.setTableKey(CommonUtils.randomUUID());
            user.setCreateTime(new Date());
            userBasicInfoRepository.save(user);
        }else{
            UserBasicInfo userinfo = userBasicInfoRepository.findByTableKey(user.getTableKey());
            userinfo.setUpdateTime(new Date());
            userinfo.setCreateTime(user.getCreateTime());
            userinfo.setPassword(user.getPassword());
            userinfo.setNickName(user.getNickName());
            userinfo.setPhone(user.getPhone());
            userBasicInfoRepository.save(userinfo);
        }
    }
}

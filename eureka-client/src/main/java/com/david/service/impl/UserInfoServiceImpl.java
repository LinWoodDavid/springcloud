package com.david.service.impl;

import com.david.dao.UserInfoMapper;
import com.david.model.UserInfo;
import com.david.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * =================================
 * Created by David on 2019/4/25.
 * mail:    17610897521@163.com
 * 描述:
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    UserInfoMapper userInfoMapper;

    /**
     * 获取所有
     *
     * @return
     */
    @Override
    public List<UserInfo> findAll() {
        return userInfoMapper.findAll();
    }
}

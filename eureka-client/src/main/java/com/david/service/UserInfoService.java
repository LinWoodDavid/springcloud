package com.david.service;

import com.david.model.UserInfo;

import java.util.List;

/**
 * =================================
 * Created by David on 2019/4/25.
 * mail:    17610897521@163.com
 * 描述:
 */

public interface UserInfoService {

    //获取所有
    List<UserInfo> findAll();
}

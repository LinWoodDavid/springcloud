package com.david.dao;

import com.david.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    //获取所有
    List<UserInfo> findAll();
}
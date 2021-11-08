package com.qiuqian.dao;

import com.qiuqian.domain.User;

import java.util.List;

//Mapper组件相当于DAO组件
public interface UserMapper {
    //插入语句
    int saveUser(User user);

    //更新语句
    int updateUser(User user);

    //删除语句
    void deleteNews(Integer id);

    //查询语句
    List<User> findUsers(Integer id);
}
package com.netease.ad.service;

import com.netease.ad.domain.User;

import java.util.List;

/**
 * Created by bjzhuyucheng on 2017/4/21.
 */
public interface UserService {
    /**
     * 新增用户
     * @param name
     * @param age
     * @return
     */
    void create(String name, Integer age);

    /**
     * 根据用户名删除
     * @param name
     * @return
     */
    void deleteByName(String name);

    /**
     * 获取用户总量
     * @return
     */
    Long getAllUsers();

    /**
     * 删除所有用户
     */
    void deleteAllUsers();

    List<User> getUserList();

    User queryById(Long id);

    void update(Long id, User user);

    void delete(Long id);
}

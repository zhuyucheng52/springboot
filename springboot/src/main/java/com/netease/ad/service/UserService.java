package com.netease.ad.service;

import com.netease.ad.domain.User;

import java.util.List;

/**
 * Created by bjzhuyucheng on 2017/4/21.
 */
public interface UserService {
    User create(User user);

    List<User> getUserList();

    User queryById(Long id);

    User update(Long id, User user);

    void delete(Long id);

    Long userCount();
}

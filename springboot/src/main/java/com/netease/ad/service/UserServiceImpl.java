package com.netease.ad.service;

import com.netease.ad.dao.UserRepository;
import com.netease.ad.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by bjzhuyucheng on 2017/4/21.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void create(String name, Integer age) {
        User u = new User();
        u.setName(name);
        u.setAge(age);

        userRepository.save(u);
    }

    @Override
    public void deleteByName(String name) {
        userRepository.deleteByName(name);
    }

    @Override
    public Long getAllUsers() {
        return userRepository.findCount();
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public User queryById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public void update(Long id, User user) {
        User u = userRepository.findOne(id);
        Assert.notNull(u, "用户不存在");
        u.setName(user.getName());
        u.setAge(user.getAge());
        userRepository.saveAndFlush(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }
}

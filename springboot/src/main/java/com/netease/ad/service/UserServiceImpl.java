package com.netease.ad.service;

import com.netease.ad.dao.UserRepository;
import com.netease.ad.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by bjzhuyucheng on 2017/4/21.
 */
@Service
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisTemplate<Long, User> redisTemplate;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) {
        User u = userRepository.save(user);
        redisTemplate.opsForValue().set(u.getId(), u);
        return u;
    }

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public User queryById(Long id) {
        User u = redisTemplate.opsForValue().get(id);
        if (null == u) {
            log.info("redis do not have user id={}, query user from database", id);
            u = userRepository.findOne(id);
        }
        return u;
    }

    @Override
    public User update(Long id, User user) {
        User u = userRepository.findOne(id);
        Assert.notNull(u, "用户不存在");
        u.setName(user.getName());
        u.setAge(user.getAge());
        u = userRepository.saveAndFlush(user);
        redisTemplate.opsForValue().set(id, u);
        return u;
    }

    @Override
    public void delete(Long id) {
        User u = userRepository.findOne(id);
        Assert.notNull(u, "用户不存在");
        userRepository.delete(id);
    }

    public Long userCount() {
        return userRepository.findCount();
    }
}

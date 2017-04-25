package com.netease.ad.dao;

import com.netease.ad.domain.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by bjzhuyucheng on 2017/4/21.
 */
@CacheConfig(cacheNames = "users")
public interface UserRepository extends JpaRepository<User, Long> {
    @Cacheable
    List<User> findByName(String name);

    User findByNameAndAge(String name, Integer age);

    @Query(value = "select count(1) from user", nativeQuery = true)
    Long findCount();

    void deleteByName(String name);
}

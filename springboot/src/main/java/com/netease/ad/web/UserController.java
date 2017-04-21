package com.netease.ad.web;

import com.netease.ad.domain.User;
import com.netease.ad.error.MyException;
import com.netease.ad.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by bjzhuyucheng on 2017/4/20.
 */
@RestController
@RequestMapping(value = "/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> getUserList() {
        log.debug("query user list");
        return userService.getUserList();
    }

    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user) {
        log.info("add user={}", user);
        userService.create(user);
        return "success";
    }

    @ApiOperation(value = "获取用户详细信息", notes = "根据url中id获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable(value = "id") Long id) {
        log.debug("get user by id={}", id);
        return userService.queryById(id);
    }

    @ApiOperation(value = "更新用户详细信息", notes = "根据url中id来更新对象")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @ModelAttribute User user) {
        log.info("update user id={} to name={} age={}", id, user.getName(), user.getAge());
        userService.update(id, user);
        return "success";
    }

    @ApiOperation(value = "删除用户", notes = "根据url中id删除指定对象")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        log.info("delete user id={}", id);
        userService.delete(id);
        return "success";
    }

    @ApiOperation(value = "用户总数", notes = "获取用户总数")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public Long userCount() {
        log.debug("user count");
        return userService.userCount();
    }

    @ApiOperation(value = "触发异常", notes = "触发异常")
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String error() {
        throw new MyException("throws exception on purpose");
    }
}

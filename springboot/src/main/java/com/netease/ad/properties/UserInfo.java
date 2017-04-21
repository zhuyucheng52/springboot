package com.netease.ad.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by bjzhuyucheng on 2017/4/21.
 */
@Component
@Data
public class UserInfo {
    @Value("${springboot.test.user}")
    private String username;

    @Value("${springboot.test.address}")
    private String address;

    @Value("${springboot.test.age}")
    private String age;
}

package com.netease.ad.schedule;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by bjzhuyucheng on 2017/4/21.
 */
@Component
@Slf4j
public class ScheduledTasks {
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("现在时间是：{}", DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss.SSS"));
    }
}

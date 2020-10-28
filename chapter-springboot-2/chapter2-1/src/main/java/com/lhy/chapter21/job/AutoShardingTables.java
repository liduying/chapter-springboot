package com.lhy.chapter21.job;

import com.lhy.chapter21.service.AlarmRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @program: chapter-springboot
 * @description: 自动创建表
 * @author: lihy
 * @create: 2020-10-26 15:49
 **/
@EnableScheduling
@Component
@Slf4j
public class AutoShardingTables {

    @Autowired
    private AlarmRecordService alarmRecordService;

    private DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyyMM");

    @Scheduled(cron = "0 0 23 28-31 * ?")
    public void createShardingAutoTables(){
        LocalDateTime nowDateTime = LocalDateTime.now();
        LocalDateTime plusMonthDateTime = nowDateTime.plusMonths(1);
        String originTableName = "app_org_tranport_status";
        String tableName = originTableName + "_" + dateformat.format(plusMonthDateTime);
        log.info("定时创建月份表 - {}  - {} - {} " , nowDateTime, originTableName, tableName );
        alarmRecordService.autoCreateMonthTable(tableName,originTableName);
    }
}

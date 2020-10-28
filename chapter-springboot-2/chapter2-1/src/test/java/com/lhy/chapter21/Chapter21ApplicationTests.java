package com.lhy.chapter21;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lhy.chapter21.entity.AlarmRecord;
import com.lhy.chapter21.entity.AppInfo;
import com.lhy.chapter21.service.AlarmRecordService;
import com.lhy.chapter21.service.AppInfoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class Chapter21ApplicationTests {

    @Autowired
    AlarmRecordService alarmRecordService;
    @Autowired
    AppInfoService appInfoService;


    @Test
    public void saveAppInfo(){
        AppInfo appInfo = new AppInfo();
        appInfo.setName("test");
        appInfo.setUrl("");
        appInfoService.save(appInfo);
    }
}

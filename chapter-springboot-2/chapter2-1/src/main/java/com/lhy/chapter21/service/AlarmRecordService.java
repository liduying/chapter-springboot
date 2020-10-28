package com.lhy.chapter21.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lhy.chapter21.entity.AlarmRecord;

/**
 * @program: chapter-springboot
 * @description:
 * @author: lihy
 * @create: 2020-10-11 16:49
 **/
public interface AlarmRecordService extends IService<AlarmRecord> {

    boolean autoCreateMonthTable(String monthTableName,String originTableName);

}

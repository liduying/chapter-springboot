package com.lhy.chapter21.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhy.chapter21.entity.AlarmRecord;
import com.lhy.chapter21.mapper.AlarmRecordMapper;
import com.lhy.chapter21.service.AlarmRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * @program: chapter-springboot
 * @description:
 * @author: lihy
 * @create: 2020-10-11 16:49
 **/
@Service
@Slf4j
public class AlarmRecordServiceImpl extends ServiceImpl<AlarmRecordMapper, AlarmRecord> implements AlarmRecordService {

    @Override
    public boolean autoCreateMonthTable(String monthTableName,String originTableName) {
        try {
            return baseMapper.createTable(monthTableName,originTableName);
        }catch (Exception e){
            log.info("{} - 表已经存在。" , monthTableName);
            return false;
        }
    }
}

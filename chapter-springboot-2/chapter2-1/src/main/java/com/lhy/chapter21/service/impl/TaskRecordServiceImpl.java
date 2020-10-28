package com.lhy.chapter21.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhy.chapter21.entity.TaskRecord;
import com.lhy.chapter21.mapper.TaskRecordMapper;
import com.lhy.chapter21.service.TaskRecordService;
import org.springframework.stereotype.Service;

/**
 * <p>
    * 任务记录表 服务实现类
    * </p>
 *
 * @author test
 * @since 2020-10-26
 */
@Service
public class TaskRecordServiceImpl extends ServiceImpl<TaskRecordMapper, TaskRecord> implements TaskRecordService {

}

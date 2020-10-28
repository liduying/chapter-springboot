package com.lhy.chapter21.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lhy.chapter21.entity.TaskRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
    * 任务记录表 Mapper 接口
    * </p>
 *
 * @author test
 * @since 2020-10-26
 */
@Mapper

public interface TaskRecordMapper extends BaseMapper<TaskRecord> {

}

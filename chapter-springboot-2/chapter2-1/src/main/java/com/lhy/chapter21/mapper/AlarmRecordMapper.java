package com.lhy.chapter21.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lhy.chapter21.entity.AlarmRecord;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @program: chapter-springboot
 * @description:
 * @author: lihy
 * @create: 2020-10-11 16:53
 **/
public interface AlarmRecordMapper extends BaseMapper<AlarmRecord> {

    @Select({"CREATE TABLE IF NOT EXISTS ${tableName} LIKE ${originTableName}"})
    boolean createTable(@Param("tableName") String tableName , @Param("originTableName") String originTableName);
}

package com.lhy.chapter21.config.shardingalgorithm;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

/**
 * @program: chapter-springboot
 * @description: 报警记录日期精确分片算法  分片键 alarm_status_time
 * @author: lihy
 * @create: 2020-10-11 15:36
 **/
public class TimeMonthPreciseShardingTableAlgorithm implements PreciseShardingAlgorithm<String> {

    private DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyyMM");

    private DateTimeFormatter dateTimeformat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<String> preciseShardingValue) {
        LocalDateTime localDateTime = LocalDateTime.parse(preciseShardingValue.getValue(),dateTimeformat);
        String value = dateformat.format(localDateTime);
        String tableName = preciseShardingValue.getLogicTableName();
        return tableName.concat("_").concat(value);
    }
}

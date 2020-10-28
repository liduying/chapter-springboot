package com.lhy.chapter21.config.shardingalgorithm;

import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @program: chapter-springboot
 * @description:
 * @author: lihy
 * @create: 2020-10-11 15:59
 **/
public class TimeMonthRangeShardingTableAlgorithm implements RangeShardingAlgorithm<String> {

    private DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyyMM");

    private DateTimeFormatter dateTimeformat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<String> rangeShardingValue) {
        Range<String> valueRange = rangeShardingValue.getValueRange();
        LocalDateTime startLocalDateTime = LocalDateTime.parse(valueRange.lowerEndpoint(),dateTimeformat);
        LocalDateTime endLocalDateTime = LocalDateTime.parse(valueRange.upperEndpoint(),dateTimeformat);
        String logicTableName = rangeShardingValue.getLogicTableName();
        // 增加范围的表 时间范围 是开始日期-结束日期，涉及跨年
        long distance = ChronoUnit.MONTHS.between(startLocalDateTime, endLocalDateTime);
        List<String> resultList = new ArrayList<>();
        if(distance < 1){
            resultList.add(dateformat.format(startLocalDateTime));
        } else {
            for(int i = 0 ; i <= distance; i++){
                resultList.add(logicTableName + "_" + dateformat.format(startLocalDateTime.plusMonths(i)));
            }
        }
        return resultList;
    }
}

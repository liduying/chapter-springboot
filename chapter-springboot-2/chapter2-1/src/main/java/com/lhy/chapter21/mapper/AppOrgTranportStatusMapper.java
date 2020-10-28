package com.lhy.chapter21.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lhy.chapter21.entity.AppOrgTranportStatus;
import com.lhy.chapter21.vo.AppOrgTranportStatisticVO;
import com.lhy.chapter21.vo.AppOrgTransportTableVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
    *  Mapper 接口
    * </p>
 *
 * @author test
 * @since 2020-10-26
 */
@Mapper
public interface AppOrgTranportStatusMapper extends BaseMapper<AppOrgTranportStatus> {

    List<AppOrgTransportTableVO>  getAppOrgTransportTableInfo(@Param("startDate") String startDate, @Param("endDate") String endDate);

    List<AppOrgTranportStatisticVO> findAppOrgTransportOnlineRateByDate(@Param("startDate") String startDate, @Param("endDate") String endDate);

}

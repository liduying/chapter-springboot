package com.lhy.chapter21.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lhy.chapter21.entity.AppOrgTranportStatus;
import com.lhy.chapter21.vo.AppOrgTranportStatisticVO;
import com.lhy.chapter21.vo.AppOrgTransportTableVO;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
    *  服务类
    * </p>
 *
 * @author test
 * @since 2020-10-26
 */
public interface AppOrgTranportStatusService extends IService<AppOrgTranportStatus> {

    IPage<AppOrgTransportTableVO> getAppOrgTransportTableInfo(Page page, String startDate, String endDate);

    List<AppOrgTranportStatisticVO> findAppOrgTransportOnlineRateByDate(String startDate, String endDate);
}

package com.lhy.chapter21.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhy.chapter21.entity.AppOrgTranportStatus;
import com.lhy.chapter21.mapper.AppOrgTranportStatusMapper;
import com.lhy.chapter21.service.AppOrgTranportStatusService;
import com.lhy.chapter21.vo.AppOrgTranportStatisticVO;
import com.lhy.chapter21.vo.AppOrgTransportTableVO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
    *  服务实现类
    * </p>
 *
 * @author test
 * @since 2020-10-26
 */
@Service
public class AppOrgTranportStatusServiceImpl extends ServiceImpl<AppOrgTranportStatusMapper, AppOrgTranportStatus> implements AppOrgTranportStatusService {

    @Override
    public IPage<AppOrgTransportTableVO> getAppOrgTransportTableInfo(Page page, String startDate, String endDate) {
        List<AppOrgTransportTableVO> appOrgTransportTableVOS = baseMapper.getAppOrgTransportTableInfo(startDate,endDate);
        // 构建异常时长的数据加分页
        if(CollectionUtils.isNotEmpty(appOrgTransportTableVOS)){
            for(AppOrgTransportTableVO appOrgTransportTableVO : appOrgTransportTableVOS){
                LocalDateTime statusTime = appOrgTransportTableVO.getStatusTime();
            }
        }
        page.setRecords(appOrgTransportTableVOS);
        return page;
    }

    @Override
    public List<AppOrgTranportStatisticVO> findAppOrgTransportOnlineRateByDate(String startDate, String endDate) {
        return baseMapper.findAppOrgTransportOnlineRateByDate(startDate,endDate);
    }

}

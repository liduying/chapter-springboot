package com.lhy.chapter21.transport;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhy.chapter21.Chapter21ApplicationTests;
import com.lhy.chapter21.entity.AppInfo;
import com.lhy.chapter21.entity.AppOrgTranportStatus;
import com.lhy.chapter21.service.AppInfoService;
import com.lhy.chapter21.service.AppOrgTranportStatusService;
import com.lhy.chapter21.vo.AppOrgTranportStatisticVO;
import com.lhy.chapter21.vo.AppOrgTransportTableVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


/**
 * @program: chapter-springboot
 * @description: 联网数据测试
 * @author: lihy
 * @create: 2020-10-26 17:54
 **/
public class TransportTest extends Chapter21ApplicationTests {

    @Autowired
    private AppOrgTranportStatusService appOrgTranportStatusService;

    @Autowired
    private AppInfoService appInfoService;

    @Test
    public void saveTransports() {
        LocalDateTime nowDateTime = LocalDateTime.now();
        LocalDateTime plusMonth = nowDateTime.plusMonths(1);
        AppOrgTranportStatus appOrgTranportStatus = new AppOrgTranportStatus();
        appOrgTranportStatus.setAppId("test");
        appOrgTranportStatus.setCode("1");
        appOrgTranportStatus.setStatusCode("1");
        appOrgTranportStatus.setStatusMsg("异常");
        appOrgTranportStatus.setStatusTime(nowDateTime);
        appOrgTranportStatusService.save(appOrgTranportStatus);
        AppOrgTranportStatus appOrgTranportStatus2 = new AppOrgTranportStatus();
        appOrgTranportStatus2.setAppId("test");
        appOrgTranportStatus2.setCode("2");
        appOrgTranportStatus2.setStatusCode("0");
        appOrgTranportStatus2.setStatusMsg("正常");
        appOrgTranportStatus2.setStatusTime(plusMonth);
        appOrgTranportStatusService.save(appOrgTranportStatus2);
    }

    @Test
    public void findTransport() {
        LocalDateTime nowDateTime = LocalDateTime.now().minusDays(1);
        LocalDateTime plusMonth = nowDateTime.plusMonths(1).plusDays(1);
        LambdaQueryWrapper<AppOrgTranportStatus> lambdaQueryWrapper = new QueryWrapper<AppOrgTranportStatus>().lambda();
        lambdaQueryWrapper.le(AppOrgTranportStatus::getStatusTime,plusMonth);
        lambdaQueryWrapper.ge(AppOrgTranportStatus::getStatusTime,nowDateTime);
        List<AppOrgTranportStatus> list = appOrgTranportStatusService.list(lambdaQueryWrapper);
        Assertions.assertEquals(list.size() , 2);
    }

    @Test
    public void batchSaveTransportMock(){
        String time = "2020-11-01 12:00:00";
        DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime nowDateTime = LocalDateTime.parse(time,dateformat);
        List<AppOrgTranportStatus> appOrgTranportStatuses = new ArrayList<>(3000000);
        for(int i = 0 ; i < 10000 ; i++){
            AppOrgTranportStatus appOrgTranportStatus = new AppOrgTranportStatus();
            appOrgTranportStatus.setAppId("test");
            appOrgTranportStatus.setCode("1");
            appOrgTranportStatus.setStatusCode("1");
            appOrgTranportStatus.setStatusMsg("异常");
            appOrgTranportStatus.setStatusTime(nowDateTime.plusSeconds(i));
            appOrgTranportStatuses.add(appOrgTranportStatus);
        }
        appOrgTranportStatusService.saveBatch(appOrgTranportStatuses);
    }

    @Test
    public void saveAppInfo(){
        AppInfo appInfo = new AppInfo();
        appInfo.setCode("test");
        appInfo.setName("测试app");
        appInfo.setUrl("");
        appInfoService.save(appInfo);
    }

    /**
     * 查询异常时长数据带分页。
     */
    @Test
    public void getAppOrgTransportTableInfo(){
        Page page = new Page();
        page.setCurrent(1);
        page.setSize(10);
        DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse("2020-09-08",dateformat);
        LocalDate enddate = LocalDate.parse("2020-09-08",dateformat);
        IPage<AppOrgTransportTableVO> appOrgTransportTableVOIPage = appOrgTranportStatusService.getAppOrgTransportTableInfo(page,"2020-09-08","2020-11-20");
        Assertions.assertEquals(10,appOrgTransportTableVOIPage.getRecords().size());
    }

    /**
     * 查询在线率统计信息
     */
    @Test
    public void findAppOrgTransportOnlineRateByDate(){
        DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse("2020-09-08",dateformat);
        LocalDate enddate = LocalDate.parse("2020-11-20",dateformat);
        List<AppOrgTranportStatisticVO> appOrgTransportOnlineRateByDate = appOrgTranportStatusService.findAppOrgTransportOnlineRateByDate("2020-09-08 00:00:00","2020-11-20 00:00:00");
        Assertions.assertEquals(10,appOrgTransportOnlineRateByDate.size());
    }

    /**
     * 不带分片的查询
     */
    @Test
    public void findALlAppOrgTransport(){
        LambdaQueryWrapper<AppOrgTranportStatus> lambdaQueryWrapper = new QueryWrapper<AppOrgTranportStatus>().lambda();
        lambdaQueryWrapper.eq(AppOrgTranportStatus::getCode,"1");
        List<AppOrgTranportStatus> appOrgTranportStatuses = appOrgTranportStatusService.list(lambdaQueryWrapper);
        Assertions.assertEquals(10,appOrgTranportStatuses.size());
    }
}

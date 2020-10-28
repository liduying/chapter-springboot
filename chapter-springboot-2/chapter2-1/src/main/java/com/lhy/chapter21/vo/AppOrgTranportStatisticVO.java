package com.lhy.chapter21.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @program: chapter-springboot
 * @description:
 * @author: lihy
 * @create: 2020-10-28 15:03
 **/
@Data
public class AppOrgTranportStatisticVO {

    /**
     * 应用系统编码
     */

    private String appCode;

    /**
     * 在线率
     */

    private Integer normalNumber;

    /**
     * 上传率
     */

    private Integer totalNumber;
    /**
     * 在线率
     */
    private Double rate;

    /**
     * 统计日期
     */
    private String statisticDate;
}

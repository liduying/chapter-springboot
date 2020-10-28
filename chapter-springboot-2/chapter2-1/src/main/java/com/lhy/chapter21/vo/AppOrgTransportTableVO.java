package com.lhy.chapter21.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @program: chapter-springboot
 * @description: 联网vo对象
 * @author: lihy
 * @create: 2020-10-26 18:38
 **/
@Data
public class AppOrgTransportTableVO {
    /**
     * 系统名称
     */
    private String systemSourceName;
    /**
     * 传输时间
     */
    @DateTimeFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    private LocalDateTime statusTime;
    /**
     * 传输状态编码
     */
    private String statusCode;
    /**
     * 传输状态名称
     */
    private String statusName;
    /**
     * 异常时长
     */
    private String abNormalDuration;
}

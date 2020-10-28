package com.lhy.chapter21.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @program: chapter-springboot
 * @description: 联网信息表
 * @author: lihy
 * @create: 2020-10-26 18:15
 **/
@Data
public class AppOrgTranportStatus {
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    private String code;

    private String appId;

    private String statusCode;

    private String statusMsg;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime statusTime;
}

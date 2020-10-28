package com.lhy.chapter21.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @program: chapter-springboot
 * @description: 报警处置信息表
 * @author: lihy
 * @create: 2020-10-26 18:18
 **/
@Data
public class AlarmRecordHandle {
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    private String alarmDisposalTypeCode;

    private String alarmDisposalTypeName;

    private String handleMeasure;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    private String createBy;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    private String updateBy;
}

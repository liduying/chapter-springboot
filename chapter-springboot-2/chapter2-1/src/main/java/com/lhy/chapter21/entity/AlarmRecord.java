package com.lhy.chapter21.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @program: chapter-springboot
 * @description: 报警记录表
 * @author: lihy
 * @create: 2020-10-11 16:25
 **/
@Data
public class AlarmRecord {

    @TableId(value = "id", type = IdType.UUID)
    private String id;

    private String name;

    private int type;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime alarmStartTime;
}

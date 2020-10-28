package com.lhy.chapter21.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @program: chapter-springboot
 * @description: 任务记录落实表
 * @author: lihy
 * @create: 2020-10-26 18:23
 **/
@Data
public class TaskRecordTarget {
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    private String taskId;

    private String targetKey;

    private String targetKeyName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    private String createBy;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    private String updateBy;
}

package com.lhy.chapter21.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @program: chapter-springboot
 * @description:
 * @author: lihy
 * @create: 2020-10-11 16:47
 **/
@Data
public class AppInfo {

    @TableId(value = "id" , type = IdType.UUID)
    private String id;
    private String code;
    private String name;
    private String url;
}

package com.lhy.chapter21.util;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: chapter-springboot
 * @description: 返回响应类
 * @author: lihy
 * @create: 2020-10-26 18:30
 **/
@Data
@Builder
public class R<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int code;
    private String msg;
    private T data;

    public R() {
        this.code = 0;
        this.msg = "success";
    }

    public R(T data) {
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }

    public R(T data, String msg) {
        this.code = 0;
        this.msg = "success";
        this.data = data;
        this.msg = msg;
    }

    public R(Throwable e) {
        this.code = 0;
        this.msg = "success";
        this.msg = e.getMessage();
        this.code = 1;
    }
    public R(final int code, final String msg, final T data) {
        this.code = 0;
        this.msg = "success";
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}

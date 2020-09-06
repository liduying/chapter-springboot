package com.lhy.chapter12.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BlogProperties {

    @Value("${com.lhy.blog.name}")
    private String name;

    @Value("${com.lhy.blog.title}")
    private String title;

    @Value("${com.lhy.blog.desc}")
    private String desc;

    @Value("${com.lhy.blog.value}")
    private String value;

    @Value("${com.lhy.blog.number}")
    private Integer number;

    @Value("${com.lhy.blog.bignumber}")
    private Long bignumber;

    @Value("${com.lhy.blog.test1}")
    private int test1;

    @Value("${com.lhy.blog.test2}")
    private int test2;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Long getBignumber() {
        return bignumber;
    }

    public void setBignumber(Long bignumber) {
        this.bignumber = bignumber;
    }

    public int getTest1() {
        return test1;
    }

    public void setTest1(int test1) {
        this.test1 = test1;
    }

    public int getTest2() {
        return test2;
    }

    public void setTest2(int test2) {
        this.test2 = test2;
    }
}

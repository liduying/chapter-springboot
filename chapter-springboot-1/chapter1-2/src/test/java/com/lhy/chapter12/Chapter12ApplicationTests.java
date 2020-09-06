package com.lhy.chapter12;

import com.lhy.chapter12.config.BlogProperties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Chapter12Application.class)
public class Chapter12ApplicationTests {

    private static final Log log = LogFactory.getLog(Chapter12ApplicationTests.class);


    @Autowired
    private BlogProperties blogProperties;

    @Test
    public void getHello(){
        Assert.assertEquals(blogProperties.getName(), "liduying");
        Assert.assertEquals(blogProperties.getTitle(), "spring boot chapter");
        Assert.assertEquals(blogProperties.getDesc(), "liduying正在努力写《spring boot chapter》");
        log.info("随机数测试输出：");
        log.info("随机字符串 : " + blogProperties.getValue());
        log.info("随机int : " + blogProperties.getNumber());
        log.info("随机long : " + blogProperties.getBignumber());
        log.info("随机10以下 : " + blogProperties.getTest1());
        log.info("随机10-20 : " + blogProperties.getTest2());
    }
}

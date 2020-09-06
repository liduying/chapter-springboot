package com.lhy.chapter13;

import com.lhy.chapter13.web.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class Chapter13ApplicationTests {

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception{
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }
    @Test
    public void testUserController() throws Exception{
        RequestBuilder requestBuilder = null;
        // 查找users集合数据
        requestBuilder = get("/users/");
        mvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(content().string(equalTo("[]")));
        // post 增加用户

        requestBuilder = post("/users/")
                                .param("id","1")
                                .param("name","liduying")
                                .param("age","18");

        mvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(content().string(equalTo("success")));


        // 获取用户信息列表数据

        requestBuilder = get("/users/");

        mvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"liduying\",\"age\":18}]")));

        // 修改用户信息

        requestBuilder = put("/users/1")
                .param("id","1")
                .param("name","liduying")
                .param("age","30");

        mvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(content().string(equalTo("success")));


        // 获取用户信息

        requestBuilder = get("/users/1");

        mvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(content().string(equalTo("{\"id\":1,\"name\":\"liduying\",\"age\":30}")));

        // 删除用户信息

        requestBuilder = delete("/users/1");
        mvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(content().string(equalTo("success")));

    }
}

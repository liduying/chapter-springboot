package com.lhy.chapter18;


import com.lhy.chapter18.service.secondary.Message;
import com.lhy.chapter18.service.primary.User;
import com.lhy.chapter18.service.primary.UserRepository;
import com.lhy.chapter18.service.secondary.MessageRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Chapter18Application.class)
public class Chapter18ApplicationTests {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MessageRepository messageRepository;


    @Test
    public void test() {
        userRepository.save(new User("aaa", 10));
        userRepository.save(new User("bbb", 20));
        userRepository.save(new User("ccc", 30));
        userRepository.save(new User("ddd", 40));
        userRepository.save(new User("eee", 50));

        Assert.assertEquals(5, userRepository.findAll().size());

        messageRepository.save(new Message("o1", "aaaaaaaaaa"));
        messageRepository.save(new Message("o2", "bbbbbbbbbb"));
        messageRepository.save(new Message("o3", "cccccccccc"));

        Assert.assertEquals(3, messageRepository.findAll().size());

    }
}

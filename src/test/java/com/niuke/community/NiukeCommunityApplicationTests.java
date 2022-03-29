package com.niuke.community;


import com.niuke.community.dao.DiscussPostMapper;
import com.niuke.community.dao.UserMapper;
import com.niuke.community.entity.DiscussPost;
import com.niuke.community.entity.User;

import com.niuke.community.util.MailClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import javax.mail.MessagingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = NiukeCommunityApplication.class)
class NiukeCommunityApplicationTests implements ApplicationContextAware {



    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Test
    void testSelectUser() {
        User user = userMapper.selectById(101);
        System.out.println(user);

        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(101,2,5,1);
        for (DiscussPost discussPost : list) {
            System.out.println(discussPost);
        }

        int num = discussPostMapper.selectDiscussPostRows(0);
        System.out.println("一共："+num);

    }

    /*@Autowired
    private MailClient mailClient;
    @Test
    void testMail() throws MessagingException {
        mailClient.sendMail("421238744@qq.com","张涛","张涛发了第一封邮件");

    }*/
}

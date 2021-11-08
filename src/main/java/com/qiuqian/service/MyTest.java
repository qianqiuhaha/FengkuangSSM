package com.qiuqian.service;

import com.qiuqian.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void testMethodAutowrite(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        User user=applicationContext.getBean("user",User.class);
        user.getCat().shout();
        user.getDog().shout();
    }
}

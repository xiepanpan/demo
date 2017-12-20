package com.example.demo.controller;

import com.example.demo.bean.Config;
import com.example.demo.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 属性赋值给javabean
 */
@RestController
@EnableConfigurationProperties({Config.class, User.class})
public class ConfigAndUserController {

    @Autowired
    private Config config;
    @Autowired
    private User user;

    @RequestMapping(value = "/config")
    public String miya() {
        return config.getGreeting()+"==="+config.getName()
                +"==="+config.getUuid()+"==="+config.getMax();
    }

    @RequestMapping("/user")
    public String user(){
        return user.getName()+user.getAge();
    }
}

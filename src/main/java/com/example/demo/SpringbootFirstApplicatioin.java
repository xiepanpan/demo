package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class SpringbootFirstApplicatioin {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootFirstApplicatioin.class,args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext applicationContext) {
        return args-> {
            System.out.println("查看由springboot启动注入的bean");
            String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
            Arrays.sort(beanDefinitionNames);//排序
            for(String beanName:beanDefinitionNames){
                System.out.println(beanName);
            }
        };
    }
}

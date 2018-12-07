package com.dmsf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Auther: LiPan
 * @Date: 2018.12.3 15:27
 * @Description: 项目启动
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.dmsf.controller","com.dmsf.service","com.dmsf.repository","com.dmsf.domain"})
@EnableAutoConfiguration
public class AppAplication {


    public static void main(String[] args) {

                SpringApplication.run(AppAplication.class, args);

    }



}

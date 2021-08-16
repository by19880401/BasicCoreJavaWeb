package com.hicola;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling//开启定时任务功能（如果要使用@Scheduled定时任务，这里记得要先开启，否则不生效）
@SpringBootApplication
public class JavaWebDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaWebDemoApplication.class, args);
    }

}

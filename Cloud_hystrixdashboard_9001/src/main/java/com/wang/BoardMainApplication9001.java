package com.wang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class BoardMainApplication9001 {
    public static void main(String[] args) {
        SpringApplication.run(BoardMainApplication9001.class,args);
    }
}

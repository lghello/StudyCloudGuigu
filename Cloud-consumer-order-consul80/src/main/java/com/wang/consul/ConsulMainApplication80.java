package com.wang.consul;

import com.wang.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "CONSUL-PROVIDER-PAYMENT", configuration = MySelfRule.class)
public class ConsulMainApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsulMainApplication80.class,args);
    }
}

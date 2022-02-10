package com.wang.consul.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/consul")
public class ConsulController {
    @Resource
    private RestTemplate restTemplate;

    public static final String PAY_URL = "http://consul-provider-payment";

    @GetMapping("/order/hello")
    public String hello(){
        return restTemplate.getForObject(PAY_URL+"/consul/payment/hello",String.class);
    }

}

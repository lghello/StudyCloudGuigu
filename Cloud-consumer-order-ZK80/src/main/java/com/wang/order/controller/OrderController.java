package com.wang.order.controller;


import com.wang.api.entity.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {
    public static final String PAY_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/payment/hello")
    public String hello(){
        String result = restTemplate.getForObject(PAY_URL + "/payment/hello", String.class);
        return result;
    }
}

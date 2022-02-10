package com.wang.order.controller;

import com.wang.api.entity.CommonResult;
import com.wang.api.entity.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import sun.net.util.IPAddressUtil;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {
//    public static final String URL = "http://localhost:8001/";
    // 通过在eureka上注册过的微服务名称调用,这里服务名称对应的就是8001和8002两个服务
    public static final String PAYMENT_URL="http://CLOUD-PROVIDER-PAYMENT";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/payment/create")
    public CommonResult createPayment(Payment payment){
//        CommonResult result = restTemplate.getForObject(URL + "payment/create", CommonResult.class, payment);
        CommonResult result = restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
        return result;
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}

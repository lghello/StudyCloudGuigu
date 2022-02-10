package com.wang.controller;

import cn.hutool.db.sql.Order;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wang.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
//全局的服务降级方法
//@DefaultProperties(defaultFallback = "paymentInfo_Global_Fail_Handler")
public class OrderController {

    @Resource
    private OrderService orderService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/order/payment/ok/{id}")
//    @HystrixCommand
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        return orderService.paymentInfo_OK(id) + "--port:"+port;
    }

    @GetMapping("/order/payment/fail/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_Fail_Handler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
//    @HystrixCommand
    public String paymentInfo_Fail(@PathVariable("id")Integer id){
        return orderService.paymentInfo_Fail(id) + "--port:"+port;
    }

    public String paymentInfo_Global_Fail_Handler(){
        return "OrderController线程池："+Thread.currentThread().getName()+"--paymentInfo_Global_Fail_Handler"+"--port:"+port;
    }
}

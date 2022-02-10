package com.wang.hystrix.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id){
        return "线程池："+Thread.currentThread().getName()+"--paymentInfo_OK:"+id;
    }

    //服务降级
    @HystrixCommand(fallbackMethod = "paymentInfo_Fail_Handler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_Fail(Integer id){
//        int a = 10/0;
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+"--paymentInfo_Fail:"+id;
    }

    public String paymentInfo_Fail_Handler(Integer id){
        return "线程池："+Thread.currentThread().getName()+"--paymentInfo_Fail_Handler:"+id;
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentInfo_Fail_Handler",
        commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
                @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
             @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
                @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")
        })
    public String paymentCircuitBreaker(Integer id){
        if(id<0){
            throw new RuntimeException("=========id为负数");
        }
        String uuid = IdUtil.simpleUUID();
        return "线程池："+Thread.currentThread().getName()+"--paymentCircuitBreaker:"+id+"--uuid:"+uuid;
    }
}

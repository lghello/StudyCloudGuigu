package com.wang.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wang.service.impl.OrderServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
//当PROVIDER-PAYMENT-HYSTRIX的方法不可用时，服务降级为调用OrderServiceImpl里的方法
@FeignClient(value = "PROVIDER-PAYMENT-HYSTRIX",fallback = OrderServiceImpl.class)
public interface OrderService {

    @GetMapping("/payment/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/fail/{id}")
    public String paymentInfo_Fail(@PathVariable("id")Integer id);
}

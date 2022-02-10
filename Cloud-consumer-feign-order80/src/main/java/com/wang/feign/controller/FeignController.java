package com.wang.feign.controller;

import com.wang.api.entity.CommonResult;
import com.wang.api.entity.Payment;
import com.wang.feign.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class FeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/feign/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }
}

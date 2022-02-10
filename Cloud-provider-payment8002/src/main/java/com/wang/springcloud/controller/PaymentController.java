package com.wang.springcloud.controller;

import com.wang.api.entity.CommonResult;
import com.wang.api.entity.Payment;
import com.wang.springcloud.serive.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int res = paymentService.insert(payment);
        if(res>0){
            return new CommonResult(200, "插入成功,port:"+port, res);
        }
        else return new CommonResult(404, "插入失败,port:"+port,null);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if(payment!=null){
            return new CommonResult<>(200,"查询成功,port:"+port,payment);
        }
        else {
            return new CommonResult<>(404,"查询失败,port:"+port,null);
        }

    }
}

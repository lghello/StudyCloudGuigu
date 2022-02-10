package com.wang.service.impl;

import com.wang.service.OrderService;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "这是OrderServiceImpl中paymentInfo_OK";
    }

    @Override
    public String paymentInfo_Fail(Integer id) {
        return "这是OrderServiceImpl中paymentInfo_Fail";
    }
}

package com.wang.springcloud.serive;


import com.wang.api.entity.Payment;

public interface PaymentService {
    public int insert(Payment payment);
    public Payment getPaymentById(Long id);
}

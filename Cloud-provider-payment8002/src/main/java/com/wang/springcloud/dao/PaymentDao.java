package com.wang.springcloud.dao;


import com.wang.api.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    public int insert(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}

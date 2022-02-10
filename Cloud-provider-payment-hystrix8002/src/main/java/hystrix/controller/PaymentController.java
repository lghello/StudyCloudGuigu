package hystrix.controller;

import hystrix.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){

        return paymentService.paymentInfo_OK(id) + "--port:"+port;
    }

    @GetMapping("/payment/fail/{id}")
    public String paymentInfo_Fail(@PathVariable("id")Integer id){
        return paymentService.paymentInfo_Fail(id)+ "--port:"+port;
    }
}

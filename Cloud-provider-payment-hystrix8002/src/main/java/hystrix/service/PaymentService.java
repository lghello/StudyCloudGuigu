package hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id){
        return "线程池："+Thread.currentThread().getName()+"--paymentInfo_OK:"+id;
    }

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
}

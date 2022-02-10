package consul.control;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/consul")
public class ConsulControl {

    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/hello")
    public String hello(){
        return "hello--"+port+":"+ UUID.randomUUID().toString();
    }
}

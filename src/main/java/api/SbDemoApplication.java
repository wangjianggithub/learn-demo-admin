package api;

import api.service.SendService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableCaching
public class SbDemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SbDemoApplication.class, args);
        SendService service= (SendService) context.getBean("sendService");
        service.sendMessage("SpringBoot集成RabbitMQ的测试数据");
    }

}

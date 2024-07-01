package api.service.impl;

import api.service.SendService;
import jakarta.annotation.Resource;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service("sendService")
public class SendServiceImpl implements SendService {

    @Resource
    private AmqpTemplate amqpTemplate;

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend("springbootDirectExchange", "springbootDirectRouting", message);
    }

    @Override
    public void sendFanout(String message) {
        amqpTemplate.convertAndSend("fanoutExchange", "", message);
    }

    @Override
    public void sendTopic(String message) {
        amqpTemplate.convertAndSend("topicExchange", "aa.bb.cc", message);
    }

    @Override
    public void sendSimpleQueue(String message) {
        amqpTemplate.convertAndSend("springbootDirectExchange", "springbootDirectRouting", message);
    }
}

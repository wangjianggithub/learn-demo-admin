package api.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    //配置一个Direct类型的交换机
    public DirectExchange directExchange() {
        return new DirectExchange("directExchange");
    }

    //配置一个队列
//    @Bean
//    public Queue directQueue() {
//        return new Queue("springbootDirectQueue");
//    }

//    /**
//     * 配置一个队列和交换机的绑定
//     *
//     * @param directQueue    : 需要绑定的队列对象，参数名必须和某个@Bean的方法名完全相同，这样就会进行自动注入，对应 .bind()
//     * @param directExchange : 需要绑定的交换机对象，参数名必须和某个@Bean的方法名完全相同，这样就会进行自动注入，对应 .to()
//     *                       .with() 方法对应的RoutingKey
//     * @return
//     */
//    public Binding directBinding(Queue directQueue, DirectExchange directExchange) {
//        return BindingBuilder.bind(directQueue).to(directExchange).with("springbootDirectRouting");
//    }


    //配置一个Fanout类型的交换机
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    //配置一个Topic类型的交换机
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }
}
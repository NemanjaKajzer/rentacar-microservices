package com.AthorizationAndAuthentication.AthorizationAndAuthentication.rabbitMQ;



import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class SenderClass {
  
    private  RabbitTemplate rabbitTemplate=new RabbitTemplate();

    public SenderClass(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public SenderClass(){
        
    }

    public void sendMessage() {
       
      

        rabbitTemplate.convertAndSend(RabbitConfig.topicExchangeName,"foo.bar.bla", "return");
    }
    
}
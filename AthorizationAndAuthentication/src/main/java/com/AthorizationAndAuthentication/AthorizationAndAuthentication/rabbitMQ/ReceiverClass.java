package com.AthorizationAndAuthentication.AthorizationAndAuthentication.rabbitMQ;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
public class ReceiverClass {
    

    

    public void receiveMessage(final Long id){
        System.out.println("POGODIO JE RESIVERRAAAAAA");
        System.out.println("AAA id je= "+id );
    }
}
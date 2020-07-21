package com.Booking.Booking.rabbitMQ;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ReceiverClass {
    

    

    public void handleMessage(final String id){
        System.out.println("POGODIO JE BOOKING");
        System.out.println("ID USERA jeEEEEEEEEEEE="+id );
    }
}
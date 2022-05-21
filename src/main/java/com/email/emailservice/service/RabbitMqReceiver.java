package com.email.emailservice.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class RabbitMqReceiver implements RabbitListenerConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMqReceiver.class);

    @RabbitListener(queues = "mflash-queue")
    public void receivedMessage(@Payload String message) {

        logger.info("Message  Received is.. " + message);
    }

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {

    }
}
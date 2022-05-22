package com.email.emailservice.service;

import com.email.emailservice.domain.InterestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class RabbitMqReceiver implements RabbitListenerConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMqReceiver.class);

    @RabbitListener(queues = "mflash-queue")
    public void receivedMessage(InterestDTO interestDTO) {
        logger.info("hell0");
        logger.info("Message  Received is.. " + interestDTO);
        sendEmail(interestDTO);
    }
    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {

    }

    @Autowired
    EmailServiceImpl emailService;

    public void sendEmail(InterestDTO interestDTO) {
        emailService.sendEmailForSomeoneInterested(interestDTO);
    }

}
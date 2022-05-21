package com.email.emailservice.service;

import com.email.emailservice.domain.InterestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl {
    @Autowired
    private JavaMailSender emailSender;

    Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    public void sendEmailForSomeoneInterested(InterestDTO interestDTO) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(interestDTO.getUserOfferEmail());
        message.setSubject("Someone is interested in your offer!");
        message.setText("User with email " + interestDTO.getSenderEmail() +
                        " is interested in your offer.\n His message: " +
                        interestDTO.getMessage());
        emailSender.send(message);
        logger.info("Mail sent at " + interestDTO.getUserOfferEmail());
    }

   /* public void sendEmailForSomeoneProvided(InterestDTO interestDTO) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(adminRestaurantEmail);
        message.setSubject("Continue registration as an admin for " + confirmationToken.getRestaurant().getRestaurantName());
        message.setText("Please go to htttp://localhost:8080/restaurant-admin/" + confirmationToken.getToken());
        emailSender.send(message);
        logger.info("Mail sent at " + adminRestaurantEmail);
    }*/

}

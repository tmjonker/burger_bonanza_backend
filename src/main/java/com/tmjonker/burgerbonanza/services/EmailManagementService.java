package com.tmjonker.burgerbonanza.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailManagementService {

    private JavaMailSender javaMailSender;

    public EmailManagementService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(String from, String subject, String body) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
        msg.setTo("burgerbonanza3@gmail.com");
        msg.setSubject(subject);
        msg.setText(body);

        javaMailSender.send(msg);
    }
}

package com.tmjonker.burgerbonanza.controllers;

import com.tmjonker.burgerbonanza.services.EmailManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ContactController {

    private EmailManagementService emailManagementService;

    public ContactController(EmailManagementService emailManagementService) {

        this.emailManagementService = emailManagementService;
    }

    @PostMapping("/contact")
    public String sendEmail(@RequestBody Map<String, Object> payload) {

        String from = (String) payload.get("from");
        String subject = "From: " + from + " " + (String) payload.get("subject");
        String body = (String) payload.get("body");

        emailManagementService.sendEmail(from, subject, body);

        return "success";
    }
}

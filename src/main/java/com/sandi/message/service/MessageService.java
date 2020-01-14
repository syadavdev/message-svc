package com.sandi.message.service;

import com.sandi.commonsvc.activemq.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private MessageSender messageSender;

    @Value("${message.svc.queue}")
    private String messageQueue;

    @Value("${customer.svc.queue}")
    private String customerQueue;

    public boolean send(String message){
        messageSender.sendMessage(messageQueue, message);
        messageSender.sendMessage(customerQueue, message);
        return true;
    }

}

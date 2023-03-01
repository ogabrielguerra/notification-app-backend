package com.notifier.app.controller;

import com.notifier.app.model.Message;
import com.notifier.app.model.repository.MessageRepository;
import com.notifier.app.service.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class STOMPMessageController {

    final
    MessageRepository messageRepository;

    @Autowired
    MessageServiceImpl messageService;

    public STOMPMessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @MessageMapping("/hellos")
    @SendTo("/topic/greetings")
    public Message message(StompHeaderAccessor accessor, Message message) {
        messageService.sendByPush(accessor, message);
        return message;
    }
}

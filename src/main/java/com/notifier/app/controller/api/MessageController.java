package com.notifier.app.controller.api;

import com.notifier.app.model.Message;
import com.notifier.app.model.repository.MessageRepository;
import com.notifier.app.service.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/message")
public class MessageController {

    final
    MessageRepository messageRepository;

    @Autowired
    MessageServiceImpl messageService;

    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping("/")
    public List<Message> message() {
        return messageRepository.findAllByOrderByIdDesc();
    }

    @GetMapping("/channel/{id}")
    public List<Message> messagesByChannel(@PathVariable Long id) {
        return messageRepository.findAllByChannelId(id);
    }

    @GetMapping("/user/{id}")
    public List<Message> messagesByUser(@PathVariable Long id) {
        return messageRepository.findAllByUserId(id);
    }

    @PostMapping("/send")
    public ResponseEntity<HttpStatus> sendMessage(@RequestBody Message message) {
        return messageService.sendMessage(message);
    }

}

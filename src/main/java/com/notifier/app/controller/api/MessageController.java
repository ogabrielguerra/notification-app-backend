package com.notifier.app.controller.api;

import com.notifier.app.model.Message;
import com.notifier.app.model.repository.MessageRepository;
import com.notifier.app.model.NotifierUser;
import com.notifier.app.service.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
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

    @PostMapping("/save")
    public String save() throws InterruptedException {
        Message message = new Message();
        message.setUser(new NotifierUser("foo", "foo@email.com"));
        message.setBody("Foo");
        messageRepository.save(message);
        return "saved";
    }

    @GetMapping("/")
    public List<Message> message() {
        return messageRepository.findAll();
    }

    @GetMapping("/channel/{id}")
    public List<Message> messagesByChannel(@PathVariable int id) {
        return messageRepository.findAllByChannelId(id);
    }

    @GetMapping("/user/{id}")
    public List<Message> messagesByUser(@PathVariable int id) {
        return messageRepository.findAllByUserId(id);
    }

    @PostMapping("/send/email")
    public void sendMessageByEmail(@RequestBody Message message){
        messageService.sendByEmail(message);
    }

    @PostMapping("/send/sms")
    public void sendMessageBySMS(@RequestBody Message message){
        messageService.sendBySMS(message);
    }

    @PostMapping("/send/push")
    public void sendMessageByPush(StompHeaderAccessor accessor, Message message){
        //This is a fallback for STOMPMessageController, which is a preferable way to send Push Notifications
        messageService.sendByPush(message);
    }
}

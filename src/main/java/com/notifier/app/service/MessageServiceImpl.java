package com.notifier.app.service;

import com.notifier.app.model.Message;
import com.notifier.app.model.User;
import com.notifier.app.model.repository.MessageRepository;
import com.notifier.app.model.repository.NotifierUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MessageServiceImpl implements MessageService {

    final
    MessageRepository messageRepository;
    final
    NotifierUserRepository notifierUserRepository;

    Logger logger = Logger.getLogger(MessageServiceImpl.class.getName());
    @Value("${topics.default}")
    private String defaultTopic;
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    public MessageServiceImpl(MessageRepository messageRepository, NotifierUserRepository notifierUserRepository) {
        this.notifierUserRepository = notifierUserRepository;
        this.messageRepository = messageRepository;
    }

    public ResponseEntity<HttpStatus> notify(Message message) {
        try {
            List<User> users = notifierUserRepository.findAllByUserCategories_CategoryId(1);
            users.forEach((user)-> notifyUser(user, message));
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            logger.log(Level.INFO, e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    private boolean notifyUser(User user, Message message){
        return true;
    }

    private boolean sendByEmail(Message message) {
        try {
            logger.log(Level.INFO, "Sending message through Email");
            logMessageSentInDatabase(message);
            return true;
        } catch (Exception e) {
            logger.log(Level.INFO, e.getMessage());
        }
        return false;
    }

    private boolean sendBySMS(Message message) {
        try {
            logger.log(Level.INFO, "Sending message through SMS");
            logMessageSentInDatabase(message);
            return true;
        } catch (Exception e) {
            logger.log(Level.INFO, e.getMessage());
        }
        return false;
    }

    public boolean sendByPush(StompHeaderAccessor accessor, Message message) {
        String sessionId = accessor.getSessionId();


        try {
            logMessageSentInDatabase(message);
            logger.log(Level.INFO, "Sending message through Push");
            return true;
        } catch (Exception e) {
            logger.log(Level.INFO, e.getMessage());
        }
        return false;
    }

    public boolean sendByPush(Message message) {
        try {
            simpMessagingTemplate.convertAndSend(defaultTopic, message);
            logMessageSentInDatabase(message);
            return true;
        } catch (Exception e) {
            logger.log(Level.INFO, e.getMessage());
        }
        return false;
    }

    private boolean logMessageSentInDatabase(Message message) {
        Date date = new Date();
        message.setCreatedAt(new Timestamp(date.getTime()));
        try {
            messageRepository.save(message);
            return true;
        } catch (Exception e) {
            logger.log(Level.INFO, e.getMessage());
        }
        return false;
    }
}

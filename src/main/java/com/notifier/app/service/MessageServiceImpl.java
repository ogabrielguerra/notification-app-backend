package com.notifier.app.service;

import com.notifier.app.model.Message;

import java.util.Date;

import com.notifier.app.model.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Timestamp;

public class MessageServiceImpl implements MessageService {

    @Value("${topics.default}")
    private String defaultTopic;
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    Logger logger = Logger.getLogger(MessageServiceImpl.class.getName());

    final
    MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public ResponseEntity sendMessage(Message message) {
        try {
            int messageTypeId = Math.toIntExact(message.getMessageType().getId());
            switch (messageTypeId) {
                case 1:
                    sendByEmail(message);
                    break;
                case 2:
                    sendBySMS(message);
                    break;
                case 3:
                    //This is a fallback for STOMPMessageController, which is a preferable way to send Push Notifications
                    sendByPush(message);
                    break;
            }
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            logger.log(Level.INFO, e.getMessage());
        }
        return new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);
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
        message.setSessionId(sessionId);

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

package com.notifier.app.service;

import com.notifier.app.model.*;
import com.notifier.app.model.repository.MessageLogRepository;
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
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MessageServiceImpl implements MessageService {

    final
    MessageRepository messageRepository;
    final
    NotifierUserRepository notifierUserRepository;
    final
    MessageLogRepository messageLogRepository;
    Logger logger = Logger.getLogger(MessageServiceImpl.class.getName());
    @Value("${topics.default}")
    private String defaultTopic;
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    public MessageServiceImpl(MessageRepository messageRepository, NotifierUserRepository notifierUserRepository, MessageLogRepository messageLogRepository) {
        this.notifierUserRepository = notifierUserRepository;
        this.messageRepository = messageRepository;
        this.messageLogRepository = messageLogRepository;
    }

    public ResponseEntity<HttpStatus> notify(Message message) {
        try {
            List<User> users = notifierUserRepository.findAllByUserCategories_CategoryId(1);
            logMessageSentInDatabase(message);
            users.forEach((user)-> notifyUser(user, message));
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            logger.log(Level.INFO, e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    private boolean notifyUser(User user, Message message){
        Set<UserChannel> userChannels = user.getUserChannels();
        userChannels.forEach(userChannel->{
            sendMessage(userChannel.getChannel(), user, message);
        });
        return true;
    }

    private boolean sendMessage(Channel channel, User user, Message message){
        Long channelId = channel.getId();
        try{
            switch (Math.toIntExact(channelId)){
                case 1:
                    sendByEmail(user, message);
                case 2:
                    sendBySMS(user, message);
                case 3:
                    sendByPush(user, message);
            }
            return true;
        }catch (Exception e){
            logger.log(Level.INFO, e.getMessage());
        }
        return false;
    }

    private boolean sendByEmail(User user, Message message) {
        try {
            MessageLog messageLog = messageLogBuilder(user, message, 1L);
            logMessageSentToChannels(messageLog);
            logger.log(Level.INFO, "Sending message through Email");
            return true;
        } catch (Exception e) {
            logger.log(Level.INFO, e.getMessage());
        }
        return false;
    }

    private boolean sendBySMS(User user, Message message) {
        try {
            MessageLog messageLog = messageLogBuilder(user, message, 2L);
            logMessageSentToChannels(messageLog);
            logger.log(Level.INFO, "Sending message through SMS");
            return true;
        } catch (Exception e) {
            logger.log(Level.INFO, e.getMessage());
        }
        return false;
    }

    public boolean sendByPush(StompHeaderAccessor accessor, User user, Message message) {
        String sessionId = accessor.getSessionId();
        try {
            MessageLog messageLog = messageLogBuilder(user, message, 3L);
            logMessageSentToChannels(messageLog);
            logger.log(Level.INFO, "Sending message through Push");
            return true;
        } catch (Exception e) {
            logger.log(Level.INFO, e.getMessage());
        }
        return false;
    }

    public boolean sendByPush(User user, Message message) {
        try {
            MessageLog messageLog = messageLogBuilder(user, message, 3L);
            logMessageSentToChannels(messageLog);
            logger.log(Level.INFO, "Sending message through Push");
            simpMessagingTemplate.convertAndSend(defaultTopic, message);
            return true;
        } catch (Exception e) {
            logger.log(Level.INFO, e.getMessage());
        }
        return false;
    }

    private MessageLog messageLogBuilder(User user, Message message, Long channelId){
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        MessageLog messageLog = new MessageLog();
        messageLog.setMessageId(message.getId());
        messageLog.setChannelId(channelId);
        messageLog.setCreatedAt(timestamp);
        messageLog.setNotifierUserId(user.getId());
        return messageLog;
    }

    private boolean logMessageSentToChannels(MessageLog messageLog){
        try{
            messageLogRepository.save(messageLog);
            return true;
        }catch (Exception e){
            logger.log(Level.INFO, e.getMessage());
        }
        return false;
    }

    private boolean logMessageSentInDatabase(Message message) {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        message.setCreatedAt(timestamp);
        try {
            messageRepository.save(message);
            logger.log(Level.INFO, "Saving message in database at " + timestamp);
            return true;
        } catch (Exception e) {
            logger.log(Level.INFO, e.getMessage());
        }
        return false;
    }
}

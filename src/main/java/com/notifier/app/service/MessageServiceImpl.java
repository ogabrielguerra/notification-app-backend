package com.notifier.app.service;

import com.notifier.app.dto.MessageDTO;
import com.notifier.app.model.Channel;
import com.notifier.app.model.Message;
import com.notifier.app.model.User;
import com.notifier.app.model.UserChannel;
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

    Logger logger = Logger.getLogger(MessageServiceImpl.class.getName());

    @Value("${topics.default}")
    private String defaultTopic;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private MessageLogServiceImpl messageLogService;

    public MessageServiceImpl(MessageRepository messageRepository, NotifierUserRepository notifierUserRepository) {
        this.notifierUserRepository = notifierUserRepository;
        this.messageRepository = messageRepository;
    }

    public ResponseEntity<HttpStatus> notify(Message message) {
        try {
            Long categoryId = message.getCategory().getId();
            List<User> users = notifierUserRepository.findAllByUserCategories_CategoryId(categoryId);
            logMessageSentInDatabase(message);
            users.forEach((user) -> notifyUser(user, message));
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            logger.log(Level.INFO, e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    private boolean notifyUser(User user, Message message) {
        Set<UserChannel> userChannels = user.getUserChannels();
        userChannels.forEach(userChannel -> {
            sendMessage(userChannel.getChannel(), user, message);
        });
        return true;
    }

    private boolean sendMessage(Channel channel, User user, Message message) {
        Long channelId = channel.getId();
        try {
            switch (Math.toIntExact(channelId)) {
                case 1:
                    sendByEmail(user, message);
                case 2:
                    sendBySMS(user, message);
                case 3:
                    sendByPush(user, message);
            }
            return true;
        } catch (Exception e) {
            logger.log(Level.INFO, e.getMessage());
        }
        return false;
    }

    private boolean sendByEmail(User user, Message message) {
        try {
            messageLogService.logMessageSentToChannels(user, message, 1L);
            logger.log(Level.INFO, "Sending message through Email");
            return true;
        } catch (Exception e) {
            logger.log(Level.INFO, e.getMessage());
        }
        return false;
    }

    private boolean sendBySMS(User user, Message message) {
        try {
            messageLogService.logMessageSentToChannels(user, message, 2L);
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
            messageLogService.logMessageSentToChannels(user, message, 3L);
            logger.log(Level.INFO, "Sending message through Push (websocket)");
            return true;
        } catch (Exception e) {
            logger.log(Level.INFO, e.getMessage());
        }
        return false;
    }

    public boolean sendByPush(User user, Message message) {
        try {
            messageLogService.logMessageSentToChannels(user, message, 3L);
            logger.log(Level.INFO, "Sending message through Push (http)");
            //@TODO Compose message data before sending to queue
            MessageDTO messageDTO = new MessageDTO(message);
            simpMessagingTemplate.convertAndSend(defaultTopic, messageDTO);
            return true;
        } catch (Exception e) {
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

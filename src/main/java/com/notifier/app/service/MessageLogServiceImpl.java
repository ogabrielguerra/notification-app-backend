package com.notifier.app.service;

import com.notifier.app.model.Message;
import com.notifier.app.model.MessageLog;
import com.notifier.app.model.User;
import com.notifier.app.model.repository.MessageLogRepository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MessageLogServiceImpl {

    final
    MessageLogRepository messageLogRepository;
    Logger logger = Logger.getLogger(MessageLogServiceImpl.class.getName());

    public MessageLogServiceImpl(MessageLogRepository messageLogRepository) {
        this.messageLogRepository = messageLogRepository;
    }

    public MessageLog messageLogBuilder(User user, Message message, Long channelId) {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        MessageLog messageLog = new MessageLog();
        messageLog.setMessageId(message.getId());
        messageLog.setChannelId(channelId);
        messageLog.setCreatedAt(timestamp);
        messageLog.setNotifierUserId(user.getId());
        return messageLog;
    }

    public boolean logMessageSentToChannels(User user, Message message, Long channelId) {
        MessageLog messageLog = messageLogBuilder(user, message, channelId);
        try {
            messageLogRepository.save(messageLog);
            return true;
        } catch (Exception e) {
            logger.log(Level.INFO, e.getMessage());
        }
        return false;
    }
}

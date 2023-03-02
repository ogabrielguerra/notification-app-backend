package com.notifier.app.configuration;

import com.notifier.app.model.repository.MessageLogRepository;
import com.notifier.app.model.repository.MessageRepository;
import com.notifier.app.model.repository.NotifierUserRepository;
import com.notifier.app.service.MessageLogServiceImpl;
import com.notifier.app.service.MessageServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactoryConfiguration {
    @Bean
    public MessageServiceImpl messageService(MessageRepository messageRepository, NotifierUserRepository notifierUserRepository) {
        return new MessageServiceImpl(messageRepository, notifierUserRepository);
    }

    @Bean
    public MessageLogServiceImpl messageLogService(MessageLogRepository messageLogRepository) {
        return new MessageLogServiceImpl(messageLogRepository);
    }
}

package com.notifier.app.configuration;

import com.notifier.app.model.repository.MessageRepository;
import com.notifier.app.service.MessageServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactoryConfig {
    @Bean
    public MessageServiceImpl messageService(MessageRepository messageRepository) {
        return new MessageServiceImpl(messageRepository);
    }
}

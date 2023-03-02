package com.notifier.app;

import com.notifier.app.model.repository.MessageRepository;
import com.notifier.app.model.repository.NotifierUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataLoaderBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    final MessageRepository messageRepository;
    final NotifierUserRepository notifierUserRepository;

    @Autowired
    public DataLoaderBootstrap(ApplicationContext applicationContext, MessageRepository messageRepository, NotifierUserRepository notifierUserRepository) {
        this.messageRepository = messageRepository;
        this.notifierUserRepository = notifierUserRepository;
    }

    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        try {
//            new DataLoader(messageRepository, notifierUserRepository);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }
}

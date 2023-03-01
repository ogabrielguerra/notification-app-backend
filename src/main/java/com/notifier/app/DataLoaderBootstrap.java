package com.notifier.app;

import com.notifier.app.model.DataLoader;
import com.notifier.app.model.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataLoaderBootstrap  implements ApplicationListener<ContextRefreshedEvent> {

    private DataLoader dataLoader;
    private final ApplicationContext applicationContext;
    final MessageRepository messageRepository;

    @Autowired
    public DataLoaderBootstrap(ApplicationContext applicationContext, MessageRepository messageRepository) {
        this.applicationContext = applicationContext;
        this.messageRepository = messageRepository;
    }

    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
        this.dataLoader = new DataLoader(messageRepository);
    }
}

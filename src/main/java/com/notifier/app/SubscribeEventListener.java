package com.notifier.app;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

@Component
public class SubscribeEventListener implements ApplicationListener {

    public void onApplicationEvent(SessionSubscribeEvent sessionSubscribeEvent) {
        /*
        Handle event
         */
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        /*
        Handle event
         */
    }
}
package com.notifier.app.controller;

import com.notifier.app.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class STOMPMessageController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(StompHeaderAccessor accessor, Message message) throws Exception {
        Thread.sleep(1000); // simulated delay
        String id = accessor.getSessionId();
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getBody()) + "!");
    }

}
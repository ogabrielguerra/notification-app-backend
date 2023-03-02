package com.notifier.app.service;

import com.notifier.app.model.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface MessageService {
    ResponseEntity<HttpStatus> sendMessage(Message message);
}

package com.notifier.app.model.repository;

import com.notifier.app.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, String> {
    List<Message> findAllByChannelId(int id);

    List<Message> findAllByUserId(int id);

    List<Message> findAll();
}

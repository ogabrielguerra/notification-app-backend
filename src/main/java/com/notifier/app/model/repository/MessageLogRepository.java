package com.notifier.app.model.repository;

import com.notifier.app.model.MessageLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageLogRepository extends JpaRepository<MessageLog, String> {

}

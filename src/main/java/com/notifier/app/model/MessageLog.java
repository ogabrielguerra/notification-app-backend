package com.notifier.app.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "message_log")

public class MessageLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long messageId;
    private Long channelId;
    private Long notifierUserId;
    private Timestamp createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Long getNotifierUserId() {
        return notifierUserId;
    }

    public void setNotifierUserId(Long notifierUserId) {
        this.notifierUserId = notifierUserId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public MessageLog() {
    }
}

package com.notifier.app.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "message_type_id")
    private MessageType messageType;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "notifier_user_id")
    private NotifierUser user;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "channel_id")
    private Channel channel;

    private Timestamp createdAt;
    private String sessionId;

    private String body;

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public NotifierUser getUser() {
        return user;
    }

    public void setUser(NotifierUser user) {
        this.user = user;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}

package com.notifier.app.dto;

import com.notifier.app.model.Message;

import java.sql.Timestamp;

public class MessageDTO {
    private Long id;
    private Long categoryId;
    private String categoryName;
    private String body;
    private Long userId;
    private String userName;
    private Timestamp createdAt;

    public MessageDTO() {
    }

    public MessageDTO(Message message) {
        this.id = message.getId();
        this.categoryId = message.getId();
        this.categoryId = message.getCategory().getId();
        this.categoryName = message.getCategory().getName();
        this.userName = message.getUser().getName();
        this.userId = message.getUser().getId();
        this.body = message.getBody();
        this.createdAt = message.getCreatedAt();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}

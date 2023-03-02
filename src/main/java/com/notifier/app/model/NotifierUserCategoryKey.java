package com.notifier.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class NotifierUserCategoryKey {
    @Column(name = "notifier_user_id")
    private Long notifierUserId;
    @Column(name = "category_id")
    private Long categoryId;

    public Long getNotifierUserId() {
        return notifierUserId;
    }

    public void setNotifierUserId(Long notifierUserId) {
        this.notifierUserId = notifierUserId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}

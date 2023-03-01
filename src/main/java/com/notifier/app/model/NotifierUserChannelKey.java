package com.notifier.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class NotifierUserChannelKey {
    @Column(name = "notifier_user_id")
    private Long notifierUserId;
    @Column(name = "channel_id")
    private Long channelId;

    public Long getNotifierUserId() {
        return notifierUserId;
    }

    public void setNotifierUserId(Long notifierUserId) {
        this.notifierUserId = notifierUserId;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public NotifierUserChannelKey() {
    }
}

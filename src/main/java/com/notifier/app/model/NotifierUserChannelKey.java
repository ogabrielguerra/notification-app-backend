package com.notifier.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class NotifierUserChannelKey {
    @Column(name = "notifier_user_id")
    private int notifierUserId;
    @Column(name = "channel_id")
    private int channelId;

    public int getNotifierUserId() {
        return notifierUserId;
    }

    public void setNotifierUserId(int notifierUserId) {
        this.notifierUserId = notifierUserId;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public NotifierUserChannelKey() {
    }
}

package com.notifier.app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class UserChannel {

    @EmbeddedId
    UserChannelKey id;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "notifier_user_id")
    User user;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "channel_id")
    Channel channel;

    public UserChannelKey getId() {
        return id;
    }

    public void setId(UserChannelKey id) {
        this.id = id;
    }

    @JsonBackReference(value = "getNotifierUser")
    public User getNotifierUser() {
        return user;
    }

    public void setNotifierUser(User user) {
        this.user = user;
    }

    @JsonBackReference(value = "getChannel")
    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}

package com.notifier.app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class NotifierUserChannel {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "notifier_user_channel_id")
//    private int notifierUserChannelId;

    @EmbeddedId
    NotifierUserChannelKey id;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "notifier_user_id")
    NotifierUser notifierUser;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "channel_id")
    Channel channel;

    public NotifierUserChannelKey getId() {
        return id;
    }

    public void setId(NotifierUserChannelKey id) {
        this.id = id;
    }

    @JsonBackReference
    public NotifierUser getNotifierUser() {
        return notifierUser;
    }

    public void setNotifierUser(NotifierUser notifierUser) {
        this.notifierUser = notifierUser;
    }

    @JsonBackReference
    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}

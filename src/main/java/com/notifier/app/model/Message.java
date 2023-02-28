package com.notifier.app.model;

import jakarta.persistence.*;

@Entity
@Table(name="message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="message_type_id")
    private MessageType messageType;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="notifier_user_id")
    private NotifierUser user;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="channel_id")
    private Channel channel;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Message() {
    }

    public Message(int idType, int user, Channel channel, String body) {
//        this.idType = idType;
        this.user = new NotifierUser("foo", "foo@email.com");
//        this.channel = channel;
        this.body = body;
    }
}

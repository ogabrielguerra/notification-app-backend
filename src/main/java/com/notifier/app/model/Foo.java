package com.notifier.app.model;

public class Foo {
    private String body;
    private String messageType;
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public Foo(String body, String messageType) {
        this.body = body;
        this.messageType = messageType;
    }
}

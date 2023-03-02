package com.notifier.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "message_type")
public class MessageType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "message_type_id")
    private Long id;
    private String name;

    public MessageType() {
    }

    public MessageType(Long id) {
        this.id = id;
    }

    public MessageType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

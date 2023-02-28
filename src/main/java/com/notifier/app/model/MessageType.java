package com.notifier.app.model;

import jakarta.persistence.*;

@Entity
@Table(name="message_type")
public class MessageType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="message_type_id")
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

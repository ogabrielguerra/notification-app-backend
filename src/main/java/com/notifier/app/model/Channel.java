package com.notifier.app.model;

import jakarta.persistence.*;

@Entity
@Table(name="channel")
public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="channel_id")
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

    public Channel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Channel() {
    }
}

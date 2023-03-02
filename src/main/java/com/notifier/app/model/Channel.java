package com.notifier.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "channel")
public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "channel_id")
    private Long id;
    private String name;

    public Channel(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Channel(Long id) {
        this.id = id;
    }

    public Channel() {
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

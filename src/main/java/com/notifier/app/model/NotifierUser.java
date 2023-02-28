package com.notifier.app.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "notifier_user")
public class NotifierUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String email;
    @OneToMany(mappedBy = "notifierUser", cascade = CascadeType.ALL)
    Set<NotifierUserChannel> userChannels;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public NotifierUser(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Set<NotifierUserChannel> getUserChannels() {
        return userChannels;
    }

    public void setUserChannels(Set<NotifierUserChannel> userChannels) {
        this.userChannels = userChannels;
    }

    public NotifierUser() {
    }
}

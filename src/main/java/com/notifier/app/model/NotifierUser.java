package com.notifier.app.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "notifier_user")
public class NotifierUser {

    @OneToMany(mappedBy = "notifierUser", cascade = CascadeType.ALL)
    Set<NotifierUserChannel> userChannels;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;

    public NotifierUser(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public NotifierUser(Long id) {
        this.id = id;
    }

    public NotifierUser() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<NotifierUserChannel> getUserChannels() {
        return userChannels;
    }

    public void setUserChannels(Set<NotifierUserChannel> userChannels) {
        this.userChannels = userChannels;
    }
}

package com.notifier.app.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "notifier_user")
public class User {

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    Set<UserCategory> userCategories;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User(Long id) {
        this.id = id;
    }

    public User() {
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

    public Set<UserCategory> getUserCategories() {
        return userCategories;
    }

    public void setUserCategories(Set<UserCategory> userCategories) {
        this.userCategories = userCategories;
    }
}

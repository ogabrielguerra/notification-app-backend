package com.notifier.app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class UserCategory {

    @EmbeddedId
    UserCategoryKey id;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "notifier_user_id")
    User user;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "category_id")
    Category category;

    public UserCategoryKey getId() {
        return id;
    }

    public void setId(UserCategoryKey id) {
        this.id = id;
    }

    @JsonBackReference(value = "getNotifierUser")
    public User getNotifierUser() {
        return user;
    }

    public void setNotifierUser(User user) {
        this.user = user;
    }

    @JsonBackReference(value = "getCategory")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

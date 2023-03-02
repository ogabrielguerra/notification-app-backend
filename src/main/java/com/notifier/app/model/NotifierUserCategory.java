package com.notifier.app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class NotifierUserCategory {

    @EmbeddedId
    NotifierUserCategoryKey id;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "notifier_user_id")
    NotifierUser notifierUser;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "category_id")
    Category category;

    public NotifierUserCategoryKey getId() {
        return id;
    }

    public void setId(NotifierUserCategoryKey id) {
        this.id = id;
    }

    @JsonBackReference(value = "getNotifierUser")
    public NotifierUser getNotifierUser() {
        return notifierUser;
    }

    public void setNotifierUser(NotifierUser notifierUser) {
        this.notifierUser = notifierUser;
    }

    @JsonBackReference(value = "getCategory")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

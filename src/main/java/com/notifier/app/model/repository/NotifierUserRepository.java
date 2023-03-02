package com.notifier.app.model.repository;

import com.notifier.app.model.NotifierUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotifierUserRepository extends JpaRepository<NotifierUser, String> {

    List<NotifierUser> findAll();

    List<NotifierUser> findAllByUserCategories_CategoryId(int id);
}

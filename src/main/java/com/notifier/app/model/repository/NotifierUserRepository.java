package com.notifier.app.model.repository;

import com.notifier.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotifierUserRepository extends JpaRepository<User, String> {

    List<User> findAll();

    List<User> findAllByUserCategories_CategoryId(Long id);

    List<User> findAllByUserChannels_ChannelId(Long id);
}

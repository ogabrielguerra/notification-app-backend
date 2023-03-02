package com.notifier.app.controller.api;

import com.notifier.app.model.User;
import com.notifier.app.model.repository.NotifierUserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class NotifierUserController {

    final
    NotifierUserRepository notifierUserRepository;

    public NotifierUserController(NotifierUserRepository notifierUserRepository) {
        this.notifierUserRepository = notifierUserRepository;
    }

    @GetMapping("/")
    public List<User> users() {
        return notifierUserRepository.findAll();
    }

    @GetMapping("/category/{id}")
    public List<User> usersByCategory(@PathVariable Long id) {
        return notifierUserRepository.findAllByUserCategories_CategoryId(id);
    }

    @GetMapping("/channel/{id}")
    public List<User> usersByChannel(@PathVariable Long id) {
        return notifierUserRepository.findAllByUserChannels_ChannelId(id);
    }

}

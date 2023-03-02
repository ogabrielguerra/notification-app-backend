package com.notifier.app.controller.api;

import com.notifier.app.model.NotifierUser;
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
    public List<NotifierUser> users() {
        return notifierUserRepository.findAll();
    }

    @GetMapping("/channel/{id}")
    public List<NotifierUser> usersByChannel(@PathVariable int id) {
        return notifierUserRepository.findAllByUserCategories_CategoryId(id);
    }

}

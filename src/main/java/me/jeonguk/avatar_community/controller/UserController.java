package me.jeonguk.avatar_community.controller;

import lombok.RequiredArgsConstructor;
import me.jeonguk.avatar_community.api.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    @GetMapping("/auth/me") // XXX: Why auth prefix?
    public User getMe() {
        return null;//new User("1");
    }

}

package me.jeonguk.avatar_community.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    @GetMapping("/auth/me") // XXX: Why auth prefix?
    public String getMe() {
        return "OK";
    }

}

package me.jeonguk.avatar_community.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    @PostMapping("/auth/signup")
    public String signup() {
        return "OK";
    }

    @PostMapping("/auth/login")
    public String login() {
        return "OK";
    }

}

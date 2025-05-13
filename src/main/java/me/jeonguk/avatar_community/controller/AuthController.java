package me.jeonguk.avatar_community.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.jeonguk.avatar_community.api.Account;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController {

    @PostMapping("/auth/signup")
    public String signup(
            @RequestBody Account account
    ) {
        // body 출력
        log.info("Signup account: {}", account);

        return "OK";
    }

    @PostMapping("/auth/login")
    public Map<String, Object> login() {
        return Map.of(
                "accessToken", "test"
        );
    }

}

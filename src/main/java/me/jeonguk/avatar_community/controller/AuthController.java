package me.jeonguk.avatar_community.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.jeonguk.avatar_community.api.AccountCreateReq;
import me.jeonguk.avatar_community.api.AccountLoginReq;
import me.jeonguk.avatar_community.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AccountService accountService;

    @PostMapping("/auth/signup")
    public ResponseEntity<String> signup(
            @RequestBody AccountCreateReq req
    ) {
        accountService.signUp(req);

        return ResponseEntity.ok(null);
    }

    @PostMapping("/auth/login")
    public Map<String, String> login(
            @RequestBody AccountLoginReq req
    ) {
        return accountService.login(req);
    }

}

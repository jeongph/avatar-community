package me.jeonguk.avatar_community.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.jeonguk.avatar_community.api.AccountCreateReq;
import me.jeonguk.avatar_community.api.AccountLoginReq;
import me.jeonguk.avatar_community.entity.AccountEntity;
import me.jeonguk.avatar_community.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Transactional
    public void signUp(AccountCreateReq req) {
        AccountEntity newAccount = new AccountEntity(req.email(), req.password());

        accountRepository.save(newAccount);
    }

    public Map<String, String> login(AccountLoginReq req) {
        // XXX: 임시 JWT 토큰 발급
        return Map.of(
                "accessToken", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWUsImlhdCI6MTUxNjIzOTAyMn0.KMUFsIDTnFmyG3nMiGM6H9FNFUROf3wh7SmqJp-QV30"
        );
    }
}

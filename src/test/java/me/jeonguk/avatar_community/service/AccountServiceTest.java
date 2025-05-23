package me.jeonguk.avatar_community.service;

import me.jeonguk.avatar_community.api.AccountCreateReq;
import me.jeonguk.avatar_community.entity.AccountEntity;
import me.jeonguk.avatar_community.repository.AccountRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class AccountServiceTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    @DisplayName("회원가입이 성공적으로 완료된다")
    void signUp_Success() {
        // given
        AccountService accountService = new AccountService(accountRepository);
        AccountCreateReq request = new AccountCreateReq("test@example.com", "securePassword123");

        // when
        accountService.signUp(request);

        // then
        AccountEntity savedAccount = accountRepository.findByEmail("test@example.com").orElse(null);
        assertThat(savedAccount).isNotNull();
        assertThat(savedAccount.getEmail()).isEqualTo("test@example.com");
        assertThat(savedAccount.getPassword()).isEqualTo("securePassword123");
    }

}
package me.jeonguk.avatar_community.repository;

import me.jeonguk.avatar_community.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
}

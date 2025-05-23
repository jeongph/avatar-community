package me.jeonguk.avatar_community.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity(name = "accounts")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    Long id;

    String email;

    String password;

    public AccountEntity(String email, String password) {
        this.email = email;
        this.password = password;
    }
}

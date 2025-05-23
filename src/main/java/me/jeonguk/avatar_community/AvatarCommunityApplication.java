package me.jeonguk.avatar_community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AvatarCommunityApplication {

    public static void main(String[] args) {
        SpringApplication.run(AvatarCommunityApplication.class, args);
    }

}

package me.jeonguk.avatar_community.repository;

import me.jeonguk.avatar_community.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
}

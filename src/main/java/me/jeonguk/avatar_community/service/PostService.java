package me.jeonguk.avatar_community.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.jeonguk.avatar_community.api.PostCreateReq;
import me.jeonguk.avatar_community.api.PostRes;
import me.jeonguk.avatar_community.api.User;
import me.jeonguk.avatar_community.entity.PostEntity;
import me.jeonguk.avatar_community.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public void createPost(PostCreateReq req) {
        PostEntity newPost = new PostEntity(req.title(), req.description());
        postRepository.save(newPost);
    }

    public Page<PostRes> pagePosts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<PostEntity> all = postRepository.findAll(pageable);

        return all.map(post -> new PostRes(
                post.getId(),
                post.getTitle(),
                post.getDescription(),
                post.getCreatedAt(),
                1L,
                new User(1L, "테스트"),
                List.of(),
                List.of(1L),
                false,
                0L,
                0L,
                0L
        ));
    }
}

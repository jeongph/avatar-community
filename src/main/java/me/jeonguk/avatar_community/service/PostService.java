package me.jeonguk.avatar_community.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.jeonguk.avatar_community.api.PostCreateReq;
import me.jeonguk.avatar_community.api.PostListRes;
import me.jeonguk.avatar_community.entity.PostEntity;
import me.jeonguk.avatar_community.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public PostListRes pagePosts(int page, int size) {
        return null;
    }
}

package me.jeonguk.avatar_community.controller;

import lombok.RequiredArgsConstructor;
import me.jeonguk.avatar_community.api.Post;
import me.jeonguk.avatar_community.api.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    @GetMapping("/posts")
    public List<Post> pagePosts() {
        User author = new User("1");

        return List.of(
                new Post(
                        1L,
                        1L,
                        "게시글 제목 1",
                        "게시글 내용 1",
                        LocalDateTime.now(),
                        author,
                        List.of(),
                        1L,
                        false,
                        1L,
                        1L,
                        1L
                ),
                new Post(
                        2L,
                        2L,
                        "게시글 제목 2",
                        "게시글 내용 2",
                        LocalDateTime.now(),
                        author,
                        List.of(),
                        0L,
                        false,
                        2L,
                        2L,
                        2L
                )
        );
    }

}

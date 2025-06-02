package me.jeonguk.avatar_community.controller;

import lombok.RequiredArgsConstructor;
import me.jeonguk.avatar_community.api.PostCreateReq;
import me.jeonguk.avatar_community.api.PostRes;
import me.jeonguk.avatar_community.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<String> createPost(
            @RequestBody PostCreateReq req
    ) {
        postService.createPost(req);

        return ResponseEntity.ok("OK");
    }

    @GetMapping("/posts")
    public ResponseEntity<Page<PostRes>> pagePosts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        var data = postService.pagePosts(page, size);

        return ResponseEntity.ok(data);
    }

}

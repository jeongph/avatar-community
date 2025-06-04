package me.jeonguk.avatar_community.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.jeonguk.avatar_community.api.PostCreateReq;
import me.jeonguk.avatar_community.api.PostRes;
import me.jeonguk.avatar_community.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
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
        log.info("Getting page {} posts", page);
        var data = postService.pagePosts(page, size);
        log.info("Page {} posts", data.getTotalElements());

        return ResponseEntity.ok(data);
    }

}

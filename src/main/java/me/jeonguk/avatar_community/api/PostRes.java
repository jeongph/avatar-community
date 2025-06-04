package me.jeonguk.avatar_community.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

public record PostRes(
        @JsonProperty("id")
        Long postId,
        String title,
        String description,
        LocalDateTime createdAt,

        Long userId,
        User author,
        List<ImageUri> imageUris,
        List<Long> likes,
        boolean hasVote,
        Long voteCount,
        Long commentCount,
        Long viewCount
//        List<PostVote> votes,
//        List<PostComment> comments
) {

    public List<Object> getVotes() {
        return List.of();
    }

    public List<Object> getComments() {
        return List.of();
    }

}

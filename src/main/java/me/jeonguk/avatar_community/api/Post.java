package me.jeonguk.avatar_community.api;

import java.time.LocalDateTime;
import java.util.List;

public record Post(
        Long id,
        Long userId,
        String title,
        String description,
        LocalDateTime createdAt,
        User author,
        List<ImageUri> imageUris,
        Long likes,
        boolean hasVote,
        Long voteCount,
        Long commentCount,
        Long viewCount
//        List<PostVote> votes,
//        List<PostComment> comments
) {

    public Object getVotes() {
        return null;
    }

    public Object getComments() {
        return null;
    }

}

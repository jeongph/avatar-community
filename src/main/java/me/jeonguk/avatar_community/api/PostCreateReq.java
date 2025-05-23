package me.jeonguk.avatar_community.api;

import java.util.List;

public record PostCreateReq(
        String title,
        String description,
        List<ImageUri> imageUris,
        String voteTitle,
        List<VoteOption> voteOptions
) {
}



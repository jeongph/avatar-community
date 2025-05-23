package me.jeonguk.avatar_community.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public record VoteOption(
        @JsonProperty("id")
        String voteOptionId,
        Integer displayPriority,
        String content
) {
}

package com.letelumiere.twitterreverse.domain.api.model.tweets;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TweetDTO {
    private Long originId;
    private Long twitId;
    private Boolean circle;
    private String content;
    
    public Tweet toEntity(){
        return Tweet.builder()
                .twitId(twitId)
                .circle(circle)
                .content(content)
                .build();
    }
}

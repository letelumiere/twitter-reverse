package com.letelumiere.twitterreverse.domain.api.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letelumiere.twitterreverse.domain.api.dao.TweetRepository;
import com.letelumiere.twitterreverse.domain.api.model.tweets.Tweet;
import com.letelumiere.twitterreverse.domain.api.model.tweets.TweetDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class TweetService {
    @Autowired TweetRepository tweetRepository;

    public Tweet confirmTweet(TweetDTO twitDto){
        Tweet tweet = twitDto.toEntity();
        return tweetRepository.save(tweet);
    }
    
}

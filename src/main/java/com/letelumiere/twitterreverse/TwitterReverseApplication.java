package com.letelumiere.twitterreverse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.letelumiere.twitterreverse.domain.api.dao.AccountRepository;
import com.letelumiere.twitterreverse.domain.api.dao.ProfileRepository;
import com.letelumiere.twitterreverse.domain.api.model.accounts.Profile;
import com.letelumiere.twitterreverse.domain.api.model.tweets.TweetDTO;
import com.letelumiere.twitterreverse.domain.api.services.TweetService;

@SpringBootApplication
public class TwitterReverseApplication {
	@Autowired
	TweetService tweetService;

	public static void main(String[] args) {
		SpringApplication.run(TwitterReverseApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AccountRepository accountRepository, ProfileRepository profileRepository){

		return args ->{
			//Profile p1 = Profile.superFrom();
			//profileRepository.save(p1);
			
			//TweetDTO twitDto = new TweetDTO((long)3, (long)2, false, "어서 가서 이 병실 좀 지켜주시오!");
			//tweetService.confirmTweet(twitDto);
		};	
	}
}
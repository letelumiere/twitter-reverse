package com.letelumiere.twitterreverse;

import javax.persistence.Temporal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.letelumiere.twitterreverse.domain.api.dao.AccountRepository;
import com.letelumiere.twitterreverse.domain.api.dao.ProfileRepository;
import com.letelumiere.twitterreverse.domain.api.dao.TweetRepository;
import com.letelumiere.twitterreverse.domain.api.model.accounts.Account;
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
			
			Account doctor = Account.builder().screenName("@doctor").email("doctor@white.com").build();
			Account sim = Account.builder().screenName("@simyoung").email("actor@communism.com").build();
			
			
			accountRepository.save(doctor);
			accountRepository.save(sim);

			TweetDTO twitDoc = new TweetDTO((long)1, null, false, "여긴 병원입니다");
			TweetDTO twitSim = new TweetDTO((long)2, null, false, "아이구!");

			TweetRepository tweetRepository;

			tweetService.confirmTweet(twitDoc);
			tweetService.confirmTweet(twitSim);

		};	
	}
}
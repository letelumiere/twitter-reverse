package com.letelumiere.twitterreverse;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.letelumiere.twitterreverse.domain.api.accounts.AccountRepository;
import com.letelumiere.twitterreverse.domain.api.accounts.Profile;
import com.letelumiere.twitterreverse.domain.api.accounts.ProfileRepository;

@SpringBootApplication
public class TwitterReverseApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitterReverseApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AccountRepository accountRepository, ProfileRepository profileRepository){
		return args ->{
			Profile p1 = Profile.superFrom();
			profileRepository.save(p1);
			
		};
	}
}
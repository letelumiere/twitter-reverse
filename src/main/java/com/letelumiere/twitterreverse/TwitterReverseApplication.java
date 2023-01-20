package com.letelumiere.twitterreverse;

import java.util.Date;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.util.Assert;

import com.letelumiere.twitterreverse.domain.api.account.Account;
import com.letelumiere.twitterreverse.domain.api.account.AccountRepository;
import com.letelumiere.twitterreverse.domain.api.account.Profile;
import com.letelumiere.twitterreverse.domain.api.account.ProfileRepository;
import com.letelumiere.twitterreverse.domain.api.account.SettingRepository;
import com.letelumiere.twitterreverse.domain.api.account.Twitter_data;
import com.mysql.cj.log.Log;

import lombok.extern.slf4j.Slf4j;
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
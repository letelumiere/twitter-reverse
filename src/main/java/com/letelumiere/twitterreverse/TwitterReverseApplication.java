package com.letelumiere.twitterreverse;

import javax.persistence.Temporal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.letelumiere.twitterreverse.domain.api.dao.ProfileRepository;
import com.letelumiere.twitterreverse.domain.api.model.accounts.Account;
import com.letelumiere.twitterreverse.domain.api.model.profile.Profile;
import com.letelumiere.twitterreverse.domain.api.model.tweets.Tweet;
import com.letelumiere.twitterreverse.domain.api.model.twitterData.TwitterData;
import com.letelumiere.twitterreverse.domain.api.services.AccountService;
import com.letelumiere.twitterreverse.domain.api.services.OriginService;
import com.letelumiere.twitterreverse.domain.api.services.ProfileService;
import com.letelumiere.twitterreverse.domain.api.services.SettingService;
import com.letelumiere.twitterreverse.domain.api.services.TweetService;

@SpringBootApplication
public class TwitterReverseApplication {
		
	@Autowired AccountService accountService;
	@Autowired ProfileService profileService;
	@Autowired OriginService originService;
	@Autowired SettingService settingService;
	@Autowired TweetService tweetService;


	public static void main(String[] args) {
		SpringApplication.run(TwitterReverseApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ProfileRepository profileRepository){		
		return args ->{
			
			Account doctor = Account.builder()
				.screenName("@doctor")
				.email("doctor@white.com")
				.phone(00000)
				.password("1234")
				.build();
			accountService.signUpAccount(doctor);
			
			long id = doctor.getId();

			Profile doctorP = Profile.builder()
				.id(id)
				.nickname("의사양반")
				.photo("없어요")
				.introduce("여기는 백병원입니다")
				.build();
			profileService.createProfile(doctorP);
			
			TwitterData data = TwitterData.builder()
				.id(id)
				.build();
			settingService.createSettingData(id, data);
			

			Tweet tweet = Tweet.builder()
				.content("전화 없으니까 그냥 푹 쉬세요")
				.circle(false)
				.build();

			tweetService.confirmTweet(tweet);
			
			doctor.setScreenName("@phD");
			settingService.findAndUpdateScreenName("@doctor", doctor);
			
		};	

	}
}
package com.letelumiere.twitterreverse;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.letelumiere.twitterreverse.domain.api.account.Account;
import com.letelumiere.twitterreverse.domain.api.account.AccountRepository;
import com.letelumiere.twitterreverse.domain.api.account.Profile;
import com.letelumiere.twitterreverse.domain.api.model.dto.AccountDTO;

@SpringBootApplication
public class TwitterReverseApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitterReverseApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AccountRepository accountRepository) {
		return args -> {
			Account simYoung = new Account("sim", "goja@communism.com", "122", 0001111112);
			Account doctor = new Account("doctor", "mr@baek.com", "122", 232321);
			
			

			accountRepository.save(simYoung);
			accountRepository.save(doctor);
			
			Profile doc = (Profile)accountRepository.findById(doctor.getId()).get();
			System.out.println(doc.getId());
			
			// accountRepository.save(doctor);

		};
	}	
	
	
}

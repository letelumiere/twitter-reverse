package com.letelumiere.twitterreverse;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.letelumiere.twitterreverse.domain.api.model.Account;
import com.letelumiere.twitterreverse.domain.api.repository.AccountRepository;

@SpringBootApplication
public class TwitterReverseApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitterReverseApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AccountRepository accountRepository){
		return args -> {
			Account maria = new Account("maria", "maria@email.com", "1234", 00100011);
			accountRepository.save(maria);
		};
	}
			
}

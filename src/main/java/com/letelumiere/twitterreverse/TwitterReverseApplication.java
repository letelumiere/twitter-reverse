package com.letelumiere.twitterreverse;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.letelumiere.twitterreverse.domain.api.account.Account;
import com.letelumiere.twitterreverse.domain.api.account.AccountRepository;
import com.letelumiere.twitterreverse.domain.api.model.dto.AccountDTO;

@SpringBootApplication
public class TwitterReverseApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitterReverseApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AccountRepository accountRepository){
		return args -> {
//			Account maria = new Account("maria", "maria@email.com", "1234", 00100011);

			AccountDTO simYoung = new AccountDTO("simyong", "goja@communism.com", "122", 0001111112);
			AccountDTO doctor = new AccountDTO("doctor", "mr@baek.com", "122", 232321);


			//Account doohan = new Account("doohan", "kim@umi.gan", "1123", 010123);

			accountRepository.save(simYoung.toEntity());
			accountRepository.save(doctor.toEntity());

		};
	}	
	
	
}

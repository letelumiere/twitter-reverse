package com.letelumiere.twitterreverse;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.letelumiere.twitterreverse.domain.api.account.AccountRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
class TwitterReverseApplicationTests {
	@Autowired 
	AccountRepository accountRepository;



	@Test
	public void contextLoads() {
/*		
		accountRepository.save(
			Account.builder()
				.screenName("simyong")
				.email("goja@communism.com")
				.password("1234")
				.phone(112312322)
				.build()
		);
 */
		
	}

}

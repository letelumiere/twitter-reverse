package com.letelumiere.twitterreverse;

import static org.mockito.Mockito.verify;

import javax.persistence.EntityManager;

import org.aspectj.lang.annotation.Before;
import org.hamcrest.MatcherAssert;
import org.hibernate.boot.model.relational.Loggable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.letelumiere.twitterreverse.domain.api.account.Account;
import com.letelumiere.twitterreverse.domain.api.account.AccountRepository;
import com.letelumiere.twitterreverse.domain.api.account.Profile;
import com.letelumiere.twitterreverse.domain.api.account.ProfileRepository;
import com.mysql.cj.log.ProfilerEvent;

import ch.qos.logback.classic.Logger;


@SpringBootTest
class TwitterReverseApplicationTests {

}

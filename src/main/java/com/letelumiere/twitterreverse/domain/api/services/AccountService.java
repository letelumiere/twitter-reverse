package com.letelumiere.twitterreverse.domain.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.letelumiere.twitterreverse.domain.api.model.dto.AccountDTO;
import com.letelumiere.twitterreverse.domain.api.model.entity.Account;
import com.letelumiere.twitterreverse.domain.api.repository.AccountRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AccountService {       //추후 implements로 더 많은 기능 축약
    @Autowired AccountRepository accountRepository;
    //private final PasswordEncoder passwordEncoder;

    public Account getScreenName(String screenName){
        return accountRepository.findDataByScreenName(screenName);
    }

    public Account getPhone(Integer phone){
        log.info("fetching phone {}", phone);
        return accountRepository.findDataByPhone(phone);
    }

    public Account getEmail(Integer email){
        log.info("fetching email {}", email);
        return accountRepository.findDataByEmail(email);
    }

    public Account signUpAccount(AccountDTO accountDto){
        Account account = accountDto.toEntity();
        return accountRepository.save(account);
    }
    
}

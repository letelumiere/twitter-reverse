package com.letelumiere.twitterreverse.domain.api.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.letelumiere.twitterreverse.domain.api.dao.AccountRepository;
import com.letelumiere.twitterreverse.domain.api.model.accounts.Account;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Transactional
public class AccountService {       //추후 implements로 더 많은 기능 축약
    @Autowired AccountRepository accountRepository;
    //private final PasswordEncoder passwordEncoder;


    public Account getReferenceId(Long id){
        return accountRepository.getReferenceById(id);
    }

    public Account getScreenName(String screenName){
        return accountRepository.findDataByScreenName(screenName);
    }

    public Account getPhone(Integer phone){
        //log.info("fetching phone {}", phone);
        return accountRepository.findDataByPhone(phone);
    }

    public Account getEmail(String email){
        //log.info("fetching email {}", email);
        return accountRepository.findDataByEmail(email);
    }

    public List<Account> getAccountAll(){
        return accountRepository.findAll();
    }

    public Account signUpAccount(Account account){
        return accountRepository.save(account);
    }

    public void signOutAccount(Account account){
        accountRepository.delete(account);
    }

}   

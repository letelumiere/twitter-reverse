package com.letelumiere.twitterreverse.domain.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.letelumiere.twitterreverse.domain.api.account.Account;
import com.letelumiere.twitterreverse.domain.api.account.AccountRepository;
import com.letelumiere.twitterreverse.domain.api.model.dto.AccountDTO;

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

    public Account signUpAccount(Account account){
        return accountRepository.save(account);
    }

    public Account getReferenceId(Long id){
        return accountRepository.getReferenceById(id);
    }
    
    public void signOutAccount(Account account){
        accountRepository.delete(account);
    }

    /* 계정 정보 update 서비스 로직. 추후에 보완할 예정
    public void findAndUpdateAccount(Long id){
        Account responsesBody = accountRepository.getReferenceById(id);
        responsesBody.setPhone(010101);
        accountRepository.save(responsesBody);
    }
     */
    
    public List<Account> getAccountAll(){
        return accountRepository.findAll();
    }
}   

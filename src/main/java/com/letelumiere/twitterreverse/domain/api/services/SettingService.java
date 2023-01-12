package com.letelumiere.twitterreverse.domain.api.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letelumiere.twitterreverse.domain.api.account.Account;
import com.letelumiere.twitterreverse.domain.api.account.AccountRepository;
import com.letelumiere.twitterreverse.domain.api.account.ProfileRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SettingService {
    @Autowired AccountRepository accountRepository;
    @Autowired ProfileRepository profileRepository;


    
    /* 계정 정보 update 서비스 로직. 추후에 보완할 예정
    public void findAndUpdateAccount(Long id){
        Account responseBody = accountRepository.getReferenceById(id);
        responsesBody.setPhone(010101);
        accountRepository.save(responsesBody);
    }
     */

     public Account findAndUpdateScreenName(String screenName, Account account){
        Account responseBody = accountRepository.findDataByScreenName(screenName);
        responseBody.setScreenName(screenName);
        
        return accountRepository.save(responseBody);
    }

    public Account findAndUpdatePassword(String password, Account account){
        Account responseBody = accountRepository.getReferenceById(account.getId());
        responseBody.setPassword(password);
        return accountRepository.save(responseBody);
    }

    public Account findAndUpdateEmail(String email, Account account){
        Account responseBody = accountRepository.getReferenceById(account.getId());
        responseBody.setEmail(email);
        return accountRepository.save(responseBody);
    }

    //createdTime // ip포함.
    //country
    //gender
    //birth
    //age
    //languages = List<String>

    /*  인증 여부 - 추후 수정 
    public Account verified(String email, Account account){
        Account responseBody = accountRepository.getReferenceById(account.getId());
        responseBody.setEmail(email);
        return accountRepository.save(responseBody);
    }

    */
    
}

package com.letelumiere.twitterreverse.domain.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.letelumiere.twitterreverse.domain.api.model.accounts.Account;


public interface AccountRepository extends JpaRepository<Account, Long>{    
    public Account findDataByScreenName(String screenName);
    public Account findDataByPhone(Integer phone);
    public Account findDataByEmail(String email);    
    
}

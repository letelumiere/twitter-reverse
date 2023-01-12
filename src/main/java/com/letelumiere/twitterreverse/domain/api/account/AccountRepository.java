package com.letelumiere.twitterreverse.domain.api.account;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepository extends JpaRepository<Account, Long>{    
    public Account findDataByScreenName(String screenName);
    public Account findDataByPhone(Integer phone);
    public Account findDataByEmail(String email);    
    
}

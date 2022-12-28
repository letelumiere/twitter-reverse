package com.letelumiere.twitterreverse.domain.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.letelumiere.twitterreverse.domain.api.model.dto.AccountDTO;
import com.letelumiere.twitterreverse.domain.api.model.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
    public Account findDataByScreenName(String screenName);
    public Account findDataByPhone(Integer phone);
    public Account findDataByEmail(Integer email);

}

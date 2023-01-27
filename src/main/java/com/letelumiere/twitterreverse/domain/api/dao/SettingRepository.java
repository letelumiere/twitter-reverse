package com.letelumiere.twitterreverse.domain.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.letelumiere.twitterreverse.domain.api.model.accounts.Account;

public interface SettingRepository extends JpaRepository<Account, Long>{    
}

package com.letelumiere.twitterreverse.domain.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.letelumiere.twitterreverse.domain.api.model.accounts.Account;
import com.letelumiere.twitterreverse.domain.api.model.twitterData.TwitterData;

public interface SettingRepository extends JpaRepository<TwitterData, Long>{    
}

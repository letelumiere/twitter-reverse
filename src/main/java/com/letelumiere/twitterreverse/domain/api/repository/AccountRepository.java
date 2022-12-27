package com.letelumiere.twitterreverse.domain.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.letelumiere.twitterreverse.domain.api.model.Account;


public interface AccountRepository extends JpaRepository<Account, Long>{
}

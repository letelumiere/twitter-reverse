package com.letelumiere.twitterreverse.domain.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.letelumiere.twitterreverse.domain.api.model.accounts.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long>{
    
}

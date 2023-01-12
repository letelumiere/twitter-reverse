package com.letelumiere.twitterreverse.domain.api.account;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long>{
    
}

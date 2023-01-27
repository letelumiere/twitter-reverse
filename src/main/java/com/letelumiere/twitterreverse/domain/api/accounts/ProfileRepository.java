package com.letelumiere.twitterreverse.domain.api.accounts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long>{
    
}

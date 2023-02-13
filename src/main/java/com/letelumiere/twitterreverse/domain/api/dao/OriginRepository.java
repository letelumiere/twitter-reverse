package com.letelumiere.twitterreverse.domain.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.letelumiere.twitterreverse.domain.api.model.origin.Origin;

public interface OriginRepository extends JpaRepository<Origin, Long>{
    
}

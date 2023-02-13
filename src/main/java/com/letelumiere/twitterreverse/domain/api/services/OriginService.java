package com.letelumiere.twitterreverse.domain.api.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.letelumiere.twitterreverse.domain.api.dao.OriginRepository;
import com.letelumiere.twitterreverse.domain.api.model.origin.Origin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class OriginService {
    OriginRepository originRepository;

    public Origin getReferenceId(Long id){
        return originRepository.getReferenceById(id);
    }
}

package com.letelumiere.twitterreverse.domain.api.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.letelumiere.twitterreverse.domain.api.accounts.Profile;
import com.letelumiere.twitterreverse.domain.api.accounts.ProfileRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProfileService {
    ProfileRepository profileRepository;




    /*
    public void findAndUpdateProfile(Long origin_id){
        Profile responseBody = profileRepository.getReferenceById(origin_id);
        responseBody.setNickname(null);
        responseBody.setEmail(null);
        responseBody.setIntroduce(null);
        responseBody.setHeader(null);
        responseBody.setBirth(null);
        responseBody.setPhoto(null);
        responseBody.setWebsite(null);

        profileRepository.save(responseBody);
    }
     */
}   

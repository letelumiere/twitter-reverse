package com.letelumiere.twitterreverse.domain.api.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.letelumiere.twitterreverse.domain.api.account.Profile;
import com.letelumiere.twitterreverse.domain.api.account.ProfileRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProfileService {
    ProfileRepository profileRepository;


    public Profile getProfile(Long origin_id){
        return profileRepository.getReferenceById(origin_id);
    }

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

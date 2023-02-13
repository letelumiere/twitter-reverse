package com.letelumiere.twitterreverse.domain.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.letelumiere.twitterreverse.domain.api.dao.ProfileRepository;
import com.letelumiere.twitterreverse.domain.api.model.profile.Profile;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@RequiredArgsConstructor
@Transactional
public class ProfileService {
    @Autowired ProfileRepository profileRepository;


    public Profile createProfile(Profile profile){
        return profileRepository.save(profile);
    }


}
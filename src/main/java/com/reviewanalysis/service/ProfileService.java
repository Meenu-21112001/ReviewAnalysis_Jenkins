package com.reviewanalysis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.reviewanalysis.entity.Profile;

@Service
public interface ProfileService {
	public Profile addProfile(Profile profile)throws Exception;
	public Profile updateProfile(Profile profile)throws Exception;
	public String deleteProfileById(Integer profileId)throws Exception;
	public List<Profile> getAllProfile()throws Exception;
}

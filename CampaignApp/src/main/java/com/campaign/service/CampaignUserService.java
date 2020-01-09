package com.campaign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campaign.dto.CampaignUserDTO;
import com.campaign.repostory.CampaignUserRepository;

@Service
public class CampaignUserService {

	@Autowired
	CampaignUserRepository userRepo;
	
	public String createUser(CampaignUserDTO userDTO) {
		userRepo.saveAndFlush(userDTO.createEntity());
		return "OK";
	}
	
	public CampaignUserDTO fetchUser(String name) {
		if(userRepo.findById(name).isPresent()) {
			return CampaignUserDTO.valueOf(userRepo.findById(name).get());
		}
		return null;
	}
	
	public String fetchRoles() {
		return userRepo.findDistinctRoles().toString();
	}
}

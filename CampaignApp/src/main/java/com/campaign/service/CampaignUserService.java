package com.campaign.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campaign.dto.CampaignContactDTO;
import com.campaign.dto.CampaignUserDTO;
import com.campaign.entity.CampaignContact;
import com.campaign.repostory.CampaignContactRepository;
import com.campaign.repostory.CampaignUserRepository;

@Service
public class CampaignUserService {

	@Autowired
	CampaignUserRepository userRepo;
	
	@Autowired
	CampaignContactRepository contactRepo;
	
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
	
	public String createContact(CampaignContactDTO contactDTO) {
		contactRepo.saveAndFlush(contactDTO.createEntity());
		return "OK";
	}
	
	public String importContact(List<CampaignContactDTO> contactList, String listName) {
		for(CampaignContactDTO contactDTO: contactList) {
			CampaignContact newContact = contactDTO.createEntity();
			newContact.setListName(listName);
			contactRepo.saveAndFlush(newContact);
		}
		return "OK";
	}
	
	public List<CampaignContactDTO> fetchContactsByList(String listName) {
		List<CampaignContactDTO> contactList = new ArrayList<CampaignContactDTO>();
		for(CampaignContact contact: contactRepo.findContactsByList(listName)) {
			contactList.add(CampaignContactDTO.valueOf(contact));
		}
		return contactList;
	}
	
	public List<CampaignContactDTO> getAllContacts() {
		List<CampaignContactDTO> contactList = new ArrayList<CampaignContactDTO>();
		for(CampaignContact contact: contactRepo.findAll()) {
			contactList.add(CampaignContactDTO.valueOf(contact));
		}
		return contactList;
	}
}

package com.campaign.dto;

import com.campaign.entity.CampaignContact;

public class CampaignContactDTO {

	String email;
	String firstName;
	String lastName;
	String phone;
	String listName;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	
	public CampaignContact createEntity() {
		CampaignContact campaignContact = new CampaignContact();
		campaignContact.setEmail(email);
		campaignContact.setFirstName(firstName);
		campaignContact.setLastName(lastName);
		campaignContact.setPhone(phone);
		campaignContact.setListName(listName);
		return campaignContact;
	}
	
	public static CampaignContactDTO valueOf(CampaignContact campaignContact) {
		CampaignContactDTO contactDTO = new CampaignContactDTO();
		contactDTO.setEmail(campaignContact.getEmail());
		contactDTO.setFirstName(campaignContact.getFirstName());
		contactDTO.setLastName(campaignContact.getLastName());
		contactDTO.setPhone(campaignContact.getPhone());
		contactDTO.setListName(campaignContact.getListName());
		return contactDTO;
	}
	
}

package com.campaign.dto;

import com.campaign.entity.CampaignUser;

public class CampaignUserDTO {
	String userName;
	String password;
	String userRole;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	public CampaignUser createEntity() {
		CampaignUser campaignUser = new CampaignUser();
		campaignUser.setUserName(this.userName);
		campaignUser.setPassword(this.password);
		campaignUser.setUserRole(this .userRole);
		return campaignUser;
	}
	
	public static CampaignUserDTO valueOf(CampaignUser campaignUser) {
		CampaignUserDTO campaignUserDTO = new CampaignUserDTO();
		campaignUserDTO.setUserName(campaignUser.getUserName());
		campaignUserDTO.setPassword(campaignUser.getPassword());
		campaignUserDTO.setUserRole(campaignUser.getUserRole());
		return campaignUserDTO;
	}
	
}

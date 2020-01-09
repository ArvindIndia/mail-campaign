package com.campaign.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CampaignUser {

	@Id
	@Column(nullable=false, length=50)
	String userName;
	@Column(nullable=false, length=50)
	String password;
	@Column(nullable=false, length=50)
	String userRole;
	
	
	public CampaignUser() {
		super();
	}
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
	
}

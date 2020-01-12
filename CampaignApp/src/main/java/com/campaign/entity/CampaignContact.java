package com.campaign.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CampaignContact {

	@Id
	@Column(nullable=false, length=50)
	String email;
	@Column(nullable=false, length=50)
	String firstName;
	@Column(nullable=false, length=50)
	String lastName;
	@Column(nullable=true, length=50)
	String phone;
	@Column(nullable=true, length=50)
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
	
	
}

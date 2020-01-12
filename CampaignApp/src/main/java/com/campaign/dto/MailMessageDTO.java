package com.campaign.dto;

import java.sql.Timestamp;

import com.campaign.entity.MailMessage;

public class MailMessageDTO {

	Long messageId;
	Long campaignId;
	String email;
	String subscribed;
	Timestamp createdAt;
	Timestamp updatedAt;
	
	public Long getMessageId() {
		return messageId;
	}
	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}
	public Long getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(Long campaignId) {
		this.campaignId = campaignId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubscribed() {
		return subscribed;
	}
	public void setSubscribed(String subscribed) {
		this.subscribed = subscribed;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public MailMessage createEntity() {
		MailMessage mailMessage = new MailMessage();
		mailMessage.setEmail(email);
		mailMessage.setCampaignId(campaignId==null?1:campaignId);
		return mailMessage;
	}
	
}

package com.campaign.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class MailMessage {

	@Id @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="MessageIdSeqGen")
	@SequenceGenerator(allocationSize=1, schema="campaign",  name="MessageIdSeqGen", sequenceName = "messageidseq")
	Long messageId;
	@Column(nullable=false)
	Long campaignId;
	@Column(nullable=false, length=50)
	String email;
	@Column(nullable=true, length=1)
	String subscribed;
	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	Timestamp createdAt;
	@Column(nullable = false)
	@CreationTimestamp
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
			
}

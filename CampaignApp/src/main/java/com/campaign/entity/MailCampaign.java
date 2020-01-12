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
public class MailCampaign {

	@Id @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="CampaignIdSeqGen")
	@SequenceGenerator(allocationSize=1, schema="campaign",  name="CampaignIdSeqGen", sequenceName = "campaignidseq")
	Long campaignId;
	@Column(nullable=false, columnDefinition="varchar(50) default 'Default Campaign'")
	String campaignName;
	@Column(nullable=false, columnDefinition="varchar(50) default 'New Campaign from Makeathon !!!'")
	String mailSubject;
	@Column(nullable=false, columnDefinition="bigint(20) default 1")
	Long templateId;
	@Column(nullable=false, columnDefinition="varchar(50) default 'ALL'")
	String listName;
	@Column(nullable=false, columnDefinition="varchar(50) default 'Admin'")
	String createdBy;
	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	Timestamp createdAt;
	
	public Long getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(Long campaignId) {
		this.campaignId = campaignId;
	}
	public String getCampaignName() {
		return campaignName;
	}
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	public String getMailSubject() {
		return mailSubject;
	}
	public void setMailSubject(String mailSubject) {
		this.mailSubject = mailSubject;
	}
	public Long getTemplateId() {
		return templateId;
	}
	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
		
}

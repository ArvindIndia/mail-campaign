package com.campaign.dto;

import java.sql.Timestamp;

import com.campaign.entity.MailCampaign;

public class MailCampaignDTO {

	Long campaignId;
	String campaignName;
	String mailSubject;
	Long templateId;
	String listName;
	String createdBy;
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
	public MailCampaign createEntity() {
		MailCampaign mailCampaign = new MailCampaign();
		mailCampaign.setCampaignName(campaignName==null?"Default Campaign":campaignName);
		mailCampaign.setMailSubject(mailSubject==null?"Campaign from STG Makeathon !!!":mailSubject);
		mailCampaign.setTemplateId(templateId==null?1:templateId);
		mailCampaign.setListName(listName==null?"ALL":listName);
		mailCampaign.setCreatedBy(createdBy==null?"Admin":createdBy);
		return mailCampaign;
	}
	
	public static MailCampaignDTO valueOf(MailCampaign mailCampaign) {
		MailCampaignDTO campaignDTO = new MailCampaignDTO();
		campaignDTO.setCampaignId(mailCampaign.getCampaignId());
		campaignDTO.setCampaignName(mailCampaign.getCampaignName());
		campaignDTO.setMailSubject(mailCampaign.getMailSubject());
		campaignDTO.setTemplateId(mailCampaign.getTemplateId());
		campaignDTO.setListName(mailCampaign.getListName());
		return campaignDTO;
	}
}

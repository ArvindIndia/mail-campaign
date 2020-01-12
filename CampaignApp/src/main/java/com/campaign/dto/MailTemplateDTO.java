package com.campaign.dto;

import com.campaign.entity.MailTemplate;

public class MailTemplateDTO {

	Long templateId;
	String templateName;
	String sections;
	String userName;
	
	public Long getTemplateId() {
		return templateId;
	}
	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	public String getSections() {
		return sections;
	}
	public void setSections(String sections) {
		this.sections = sections;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public MailTemplate createEntity() {
		MailTemplate mailTemplate = new MailTemplate();
		mailTemplate.setTemplateName(this.templateName);
		mailTemplate.setSections(this.sections);
		mailTemplate.setUserName(this.userName);
		return mailTemplate;
	}
	
	public static MailTemplateDTO valueOf(MailTemplate mailTemplate) {
		MailTemplateDTO mailTemplateDTO = new MailTemplateDTO();
		mailTemplateDTO.setTemplateId(mailTemplate.getTemplateId());
		mailTemplateDTO.setTemplateName(mailTemplate.getTemplateName());
		mailTemplateDTO.setSections(mailTemplate.getSections());
		mailTemplateDTO.setUserName(mailTemplate.getUserName());
		return mailTemplateDTO;
	}
}

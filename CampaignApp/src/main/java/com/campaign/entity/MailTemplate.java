package com.campaign.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class MailTemplate {

	@Id @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="TemplateIdSeqGen")
	@SequenceGenerator(allocationSize=1, schema="campaign",  name="TemplateIdSeqGen", sequenceName = "templateidseq")
	Long templateId;
	@Column(nullable=false, length=50)
	String templateName;
	@Column(nullable=false, length=1024)
	String sections;
	@Column(nullable=false, length=50)
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
	
}

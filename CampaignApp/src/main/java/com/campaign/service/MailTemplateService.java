package com.campaign.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campaign.dto.MailCampaignDTO;
import com.campaign.dto.MailMessageDTO;
import com.campaign.dto.MailTemplateDTO;
import com.campaign.entity.MailCampaign;
import com.campaign.entity.MailMessage;
import com.campaign.entity.MailTemplate;
import com.campaign.repostory.MailCampaignRepository;
import com.campaign.repostory.MailMessageRepository;
import com.campaign.repostory.MailTemplateRepository;

@Service
public class MailTemplateService {

	@Autowired
	MailTemplateRepository templateRepo;
	
	@Autowired
	MailCampaignRepository campaignRepo;
	
	@Autowired
	MailMessageRepository messageRepo;
	
	public Long addTemplate(MailTemplateDTO templateDTO) {
		MailTemplate template = templateDTO.createEntity();
		templateRepo.saveAndFlush(template);
		return template.getTemplateId();
	}
	
	public MailTemplateDTO getTemplate(Long templateId) {
		if(templateRepo.findById(templateId).isPresent()) {
			return MailTemplateDTO.valueOf(templateRepo.findById(templateId).get());
		}
		return null;
	}
	
	public List<MailTemplateDTO> getAllTemplates() {
		List<MailTemplateDTO> templateList = new ArrayList<MailTemplateDTO>();
		for(MailTemplate template: templateRepo.findAll()) {
			templateList.add(MailTemplateDTO.valueOf(template));
		}
		return templateList;
	}
	
	public MailCampaignDTO addCampaign(MailCampaignDTO campaignDTO) {
		MailCampaign mailCampaign = campaignDTO.createEntity();
		campaignRepo.saveAndFlush(mailCampaign);
		return MailCampaignDTO.valueOf(mailCampaign);
	}
	
	public Long addMessage(MailMessageDTO messageDTO) {
		MailMessage mailmessage = messageDTO.createEntity();
		messageRepo.saveAndFlush(mailmessage);
		return mailmessage.getMessageId();
	}
	
	public String subscribeMail(Long messageId, String flag) {
		if(messageRepo.findById(messageId).isPresent()) {
			MailMessage mailMessage = messageRepo.findById(messageId).get();
			if(flag.equals("N")) 
				mailMessage.setSubscribed("N"); 
			else 
				mailMessage.setSubscribed("Y");
			mailMessage.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
			messageRepo.saveAndFlush(mailMessage);
			
			if(flag.equals("N")) 
				return "<div align=\"center\" style=\"border-style: double;color: red;font-size: 20;width: 70%;margin: 15%;\">"+
				"<p><b>You would be missing out on exciting rewards !!!</b></p>"+
				"<p><b>Check the mail and click subscribe to be part of the campaign.</b></p><p></p></div>";
			else
				return "<div align=\"center\" style=\"border-style: double;color: blue;font-size: 20;width: 70%;margin: 15%;\">"+
				"<p><b>Thanks for subscribing to the campaign. </b></p>"+
				"<p><b>Exciting rewards await you !!!</b></p><p></p></div>";
		}
		return "<div align=\"center\" style=\"border-style: double;color: red;font-size: 20;width: 70%;margin: 15%;\">"+
			"<p><b>Oops, something has gone wrong !!!</b></p>"+
			"<p><b>Check the mail and subscribe again.</b></p><p></p></div>";
	}
}

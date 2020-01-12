package com.campaign.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.campaign.dto.CampaignContactDTO;
import com.campaign.dto.MailCampaignDTO;
import com.campaign.dto.MailTemplateDTO;
import com.campaign.service.CampaignUserService;
import com.campaign.service.KafkaProducerService;
import com.campaign.service.MailTemplateService;

@CrossOrigin
@RestController
public class MailTemplateController {

	@Autowired
	MailTemplateService mailService;
	
	@Autowired
	KafkaProducerService bulkService;
	
	@Autowired
	CampaignUserService userService;
	
	@RequestMapping(value="/user/{message}", method=RequestMethod.GET, produces=MediaType.ALL_VALUE)
	public String helloMessage(@PathVariable String message) {
		return "Welcome " + message;
	}
	
	@RequestMapping(value="/emails/addTemplate", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public String addTemplate(@RequestBody MailTemplateDTO templateDTO) {
		return  "{\"templateId\":" + mailService.addTemplate(templateDTO) + "}";
	}
	
	@RequestMapping(value="/emails/getTemplate/{templateId}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public MailTemplateDTO getTemplate(@PathVariable Long templateId) {
		return mailService.getTemplate(templateId);
	}
	
	@RequestMapping(value="/emails/getAll", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<MailTemplateDTO> getTemplate() {
		return mailService.getAllTemplates();
	}
	
	@RequestMapping(value="/emails/sendMail", method=RequestMethod.POST)
	public void sendMail(@RequestBody MailCampaignDTO campaignDTO) {
		String mailMessage;
		MailCampaignDTO newCampaignDTO = mailService.addCampaign(campaignDTO);
		for(CampaignContactDTO contact : userService.fetchContactsByList(campaignDTO.getListName())) {
			mailMessage = "{\"sendTo\":\"" + contact.getEmail() +"\"," + 
					"\"firstName\":\"" + contact.getFirstName() + "\"," +
					"\"lastName\":\"" + contact.getLastName() + "\"," +
					"\"mailSubject\":\"" + newCampaignDTO.getMailSubject() + "\"," + 
					"\"templateId\":\"" + newCampaignDTO.getTemplateId() + "\"," +
					"\"campaignId\":\"" + newCampaignDTO.getCampaignId() + "\"}";
			bulkService.sendMessage(mailMessage);	
		}
	}
	
	@RequestMapping(value="/emails/subscribe/{messageId}/{flag}", method=RequestMethod.GET, produces=MediaType.TEXT_HTML_VALUE)
	public String subscribeMail(@PathVariable("messageId") Long messageId, @PathVariable("flag") String flag) {
		return mailService.subscribeMail(messageId, flag);
	}
	
}

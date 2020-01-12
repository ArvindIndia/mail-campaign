package com.campaign.service;

import java.io.IOException;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.core.io.FileSystemResource;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.campaign.dto.MailMessageDTO;

@EnableKafka
@Service
public class KafkaConsumerService {

	private static final String SEND_FROM = "campaign@makeathon.com";
	
	@Autowired
	MailTemplateService messageService;
	
	@Autowired
	SendGridMailService mailService;
	
	@KafkaListener(topics = "mailers", groupId = "campaignGroup")
    public void consume(String mailMessage) throws IOException, JSONException {
		FileSystemResource fileResource = new FileSystemResource("D:\\Arvind\\Bridge\\MakeathonDec2019\\mailer-campaign\\front_end\\src\\assets\\template\\email-template-4.html");
		String content = new String(Files.readAllBytes(fileResource.getFile().toPath()));
		
		JSONObject messageJSON = new JSONObject(mailMessage);
		MailMessageDTO messageDTO = new MailMessageDTO();
		messageDTO.setEmail(messageJSON.getString("sendTo"));
		messageDTO.setCampaignId(new Long(messageJSON.getString("campaignId")));
		Long messageId = messageService.addMessage(messageDTO);
		
		String newContent = content.replaceAll("@@messageId@@", messageId.toString())
				.replaceAll("@@firstName@@", messageJSON.getString("firstName"))
				.replaceAll("@@lastName@@", messageJSON.getString("lastName"));
		mailService.sendHTML(SEND_FROM, messageJSON.getString("sendTo"), messageJSON.getString("mailSubject"), newContent);
    }
	
}

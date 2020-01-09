package com.campaign.service;

import java.io.IOException;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@EnableKafka
@Service
public class ConsumerService {

	@Autowired
	SendGridMailService mailService;
	
	@KafkaListener(topics = "mailers", groupId = "campaignGroup")
    public void consume(String sendTo) throws IOException {
		FileSystemResource fileResource = new FileSystemResource("D:\\Arvind\\Bridge\\MakeathonDec2019\\mailer-campaign\\front_end\\src\\assets\\template\\email-template1-3.html");
		String content = new String(Files.readAllBytes(fileResource.getFile().toPath()));
		mailService.sendHTML("campaign@makeathon.com", sendTo, "Campaign from Makeathon !!!", content);
    }
}

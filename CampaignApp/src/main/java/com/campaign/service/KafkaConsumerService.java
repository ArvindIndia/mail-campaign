package com.campaign.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@EnableKafka
@Service
public class KafkaConsumerService {
	
	@Autowired
	SendGridMailService mailService;
	
	@KafkaListener(topics = "mailers", groupId = "campaignGroup")
    public void consume(String mailMessage) throws IOException, JSONException {		
		JSONObject messageJSON = new JSONObject(mailMessage);
		mailService.sendMessage(messageJSON);
    }
	
}

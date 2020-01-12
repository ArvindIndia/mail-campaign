package com.campaign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

	private static final String TOPIC = "mailers";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String mailMessage) {
        this.kafkaTemplate.send(TOPIC, mailMessage);
    }
}

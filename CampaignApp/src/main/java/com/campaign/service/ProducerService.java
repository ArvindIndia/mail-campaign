package com.campaign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

	private static final String TOPIC = "mailers";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String sendTo) {
        this.kafkaTemplate.send(TOPIC, sendTo);
    }
}

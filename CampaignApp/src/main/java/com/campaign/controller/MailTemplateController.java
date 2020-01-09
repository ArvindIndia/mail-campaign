package com.campaign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.campaign.service.ProducerService;

@RestController
public class MailTemplateController {

	@Autowired
	ProducerService bulkService;
	
	@CrossOrigin
	@RequestMapping(value="/hello/{message}", method=RequestMethod.GET, produces=MediaType.ALL_VALUE)
	public String helloMessage(@PathVariable String message) {
		return "Welcome " + message;
	}
	
	@RequestMapping(value="/sendMail", method=RequestMethod.POST)
	public void sendMail() {
		bulkService.sendMessage("to.arvind.india@gmail.com");
		bulkService.sendMessage("test@111.222");
	}
	
}

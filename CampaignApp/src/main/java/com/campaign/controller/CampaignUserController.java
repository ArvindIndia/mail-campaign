package com.campaign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.campaign.dto.CampaignUserDTO;
import com.campaign.service.CampaignUserService;

@CrossOrigin
@RestController
public class CampaignUserController {

	@Autowired
	CampaignUserService userService;
	
	@RequestMapping(value="/user/create", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public String createUser(@RequestBody CampaignUserDTO userDTO) {
		userService.createUser(userDTO);
		return "SUCCESS";
	}
	
	@CrossOrigin
	@RequestMapping(value="/user/{name}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public CampaignUserDTO fetchUser(@PathVariable String name) {
		return userService.fetchUser(name);
	}
	
	@RequestMapping(value="/user/roles", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public String fetchRoles() {
		return userService.fetchRoles();
	}
}

package com.campaign.repostory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.campaign.entity.CampaignContact;

public interface CampaignContactRepository extends JpaRepository<CampaignContact, String>{

	@Query("SELECT contact from CampaignContact contact where contact.listName like :list")
	List<CampaignContact> findContactsByList(@Param("list") String listName);
	
	@Query("SELECT DISTINCT contact.listName from CampaignContact contact")
	List<String> fetchContactLists();
}

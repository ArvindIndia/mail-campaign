package com.campaign.repostory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.campaign.entity.CampaignUser;

public interface CampaignUserRepository extends JpaRepository<CampaignUser, String> {

	@Query("SELECT DISTINCT user.userRole from CampaignUser user")
	List<String> findDistinctRoles();
}

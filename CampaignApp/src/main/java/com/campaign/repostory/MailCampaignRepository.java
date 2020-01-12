package com.campaign.repostory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campaign.entity.MailCampaign;

public interface MailCampaignRepository extends JpaRepository<MailCampaign, Long> {

}

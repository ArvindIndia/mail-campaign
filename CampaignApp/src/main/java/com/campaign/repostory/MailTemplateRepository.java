package com.campaign.repostory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campaign.entity.MailTemplate;

public interface MailTemplateRepository extends JpaRepository<MailTemplate, Long> {

}

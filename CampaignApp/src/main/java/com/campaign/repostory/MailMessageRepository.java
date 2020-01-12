package com.campaign.repostory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campaign.entity.MailMessage;

public interface MailMessageRepository extends JpaRepository<MailMessage, Long> {

}

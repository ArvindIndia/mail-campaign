package com.campaign.service;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;

import com.sendgrid.Attachments;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

@Service
public class SendGridMailService {

	private SendGrid sendGridClient;
	 
    @Autowired
    public SendGridMailService(SendGrid sendGridClient) {
        this.sendGridClient = sendGridClient;
    }
    
    public void sendHTML(String from, String to, String subject, String body) {
        Response response = sendEmail(from, to, subject, new Content("text/html", body));
        System.out.println("Sent to: " + to + " Status Code: " + response.getStatusCode() + ", Body: " + response.getBody() + ", Headers: " + response.getHeaders());
    }
 
    private Response sendEmail(String from, String to, String subject, Content content) {
        Mail mail = new Mail(new Email(from), subject, new Email(to), content);
        mail.setReplyTo(new Email("do-not-reply@makeathon.com"));
        
        try {
			FileSystemResource fileResource = new FileSystemResource("D:\\Arvind\\Bridge\\MakeathonDec2019\\mailer-campaign\\front_end\\src\\assets\\img\\makeathon-logo.png");
			String encodedfile = Base64.getEncoder().encodeToString(Files.readAllBytes(fileResource.getFile().toPath()));
			Attachments attachments = new Attachments();
			attachments.setContent(encodedfile);
			attachments.setContentId("myimagecid");
			attachments.setFilename("mail-logo.png");
			attachments.setDisposition("inline");
		    mail.addAttachments(attachments);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
        Request request = new Request();
        Response response = null;
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            response = this.sendGridClient.api(request);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return response;
    }
}

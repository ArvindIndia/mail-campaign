package com.campaign.service;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;

import com.campaign.dto.MailMessageDTO;
import com.campaign.dto.MailTemplateDTO;
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

	private static final String SEND_FROM = "campaign@makeathon.com";
	
	private SendGrid sendGridClient;
	
	@Autowired
	MailTemplateService messageService;
	 
    @Autowired
    public SendGridMailService(SendGrid sendGridClient) {
        this.sendGridClient = sendGridClient;
    }
    
    public void sendMessage(JSONObject messageJSON) throws JSONException, IOException {
    	
    	String templateId = messageJSON.getString("templateId");
		FileSystemResource fileResource = new FileSystemResource("D:\\Arvind\\Bridge\\MakeathonDec2019\\mailer-campaign\\front_end\\dist\\email\\email-preview-"+ templateId + ".html");
		String content = new String(Files.readAllBytes(fileResource.getFile().toPath()));
		
		MailMessageDTO messageDTO = new MailMessageDTO();
		messageDTO.setEmail(messageJSON.getString("sendTo"));
		messageDTO.setCampaignId(new Long(messageJSON.getString("campaignId")));
		Long messageId = messageService.addMessage(messageDTO);
		
		String newContent = content.replaceAll("@@messageId@@", messageId.toString())
				.replaceAll("@@firstName@@", messageJSON.getString("firstName"))
				.replaceAll("@@lastName@@", messageJSON.getString("lastName"));
		
		Mail mail = new Mail(new Email(SEND_FROM), messageJSON.getString("mailSubject"), new Email(messageJSON.getString("sendTo")), new Content("text/html",newContent));
    	mail.setReplyTo(new Email("do-not-reply@makeathon.com"));
		
		MailTemplateDTO mailTemplate = messageService.getTemplate(new Long(templateId));
		JSONArray messageSections = new JSONArray(mailTemplate.getSections()); 
		List<String> images =  new ArrayList<String>();
		for (int i = 0; i < messageSections.length(); i++) {	
			JSONObject section = messageSections.getJSONObject(i);
		    if (section.getString("type").equals("image")){
		    	String imageName = section.getString("url").substring(11, section.getString("url").length()-4);
		    	newContent = newContent.replaceAll(section.getString("url"), "cid:" + imageName.replace("-",""));
		    	String fullImage = section.getString("url").substring(11, section.getString("url").length());
		    	images.add(fullImage);
		    }  	
		}
		sendHTML(SEND_FROM, messageJSON.getString("sendTo"), messageJSON.getString("mailSubject"), newContent, images);
    }
    
    public void sendHTML(String from, String to, String subject, String body, List<String> imageList) {
    	System.out.println("body" + body);
        Response response = sendEmail(from, to, subject, new Content("text/html", body), imageList);
        System.out.println("Sent to: " + to + " Status Code: " + response.getStatusCode() + ", Body: " + response.getBody() + ", Headers: " + response.getHeaders());
    }
    
    private Response sendEmail(String from, String to, String subject, Content content, List<String> imageList) {
        Mail mail = new Mail(new Email(from), subject, new Email(to), content);
        mail.setReplyTo(new Email("do-not-reply@makeathon.com"));
        
        for (int i = 0; i < imageList.size(); i++) {	
		    	try {
		    		
					FileSystemResource imageResource = new FileSystemResource("D:\\Arvind\\Bridge\\MakeathonDec2019\\mailer-campaign\\front_end\\src\\assets\\img\\" + imageList.get(i));
					String encodedfile = Base64.getEncoder().encodeToString(Files.readAllBytes(imageResource.getFile().toPath()));
					Attachments attachments = new Attachments();
					attachments.setContent(encodedfile);
					String contentId=imageList.get(i).substring(0,imageList.get(i).length()-4).replace("-","");
					System.out.println("contentId"+contentId);
					attachments.setContentId(contentId);
					System.out.println(imageList.get(i));
					attachments.setFilename(imageList.get(i));
					attachments.setDisposition("inline");
				    mail.addAttachments(attachments);
				} catch (IOException e) {
					e.printStackTrace();
				}
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

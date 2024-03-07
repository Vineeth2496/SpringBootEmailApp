package com.SpringBootEmailApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import jakarta.mail.internet.MimeMessage;

@Component
public class MailService {
	@Autowired	//Read new JavaMailSenderImpl() from container
	private JavaMailSender sender;
	
	public boolean sendEmail(
			String to,
			String cc[],
			String bcc[],
			String subject,
			String text,
			org.springframework.core.io.Resource file
				
			) {
		boolean isSent=false;
		try {
			// create new MimeMessage
			MimeMessage message=sender.createMimeMessage();
			
			// Use Helper class and fill details (to, cc, bcc.. )
			//MimeMessageHelper helper=new MimeMessageHelper(message, file!=null?true:false);
			MimeMessageHelper helper=new MimeMessageHelper(message, file!=null);
			
			helper.setTo(to);
			if(cc!=null) {
				helper.setCc(cc);	
			}
			if(bcc!=null) {
				helper.setBcc(bcc);	
			}
			helper.setSubject(subject);
			//helper.setText(text);
			helper.setText(text, true);
			
			if(file!=null) {
				//file name,file data
				helper.addAttachment(file.getFilename(), file);
			}
			// send message
			sender.send(message);
			
			isSent=true;
		}
		catch (Exception e) {
			isSent=false;
			e.printStackTrace();
		}
		
		return isSent;
	}
	public boolean sendEmail(
			String to,
			String subject,
			String text) {
		return sendEmail(to, null, null, subject, text, null);
	}
}

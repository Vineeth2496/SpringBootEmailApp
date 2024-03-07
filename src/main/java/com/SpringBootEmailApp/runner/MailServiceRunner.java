package com.SpringBootEmailApp.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.SpringBootEmailApp.MailTemplate;
import com.SpringBootEmailApp.service.MailService;
@Component
public class MailServiceRunner implements CommandLineRunner {
	@Autowired
	private MailService ms;
	@Override
	public void run(String... args) throws Exception {
		Resource file=new FileSystemResource("F:\\SpringBoot Videos\\Practice\\SpringBootEmailApp\\src\\main\\java\\com\\SpringBootEmailApp\\margot_robbie.jpg");
		/*
		boolean sent=ms.sendEmail("vineetharmoori2496@gmail.com", 
				null, null, 
				"Welcome to Subject Email API", 
				"<html><body><h1>Hello Dude</h1><b><i></i></b></body></html>", file);
			*/
		boolean sent=ms.sendEmail("vineetharmoori2496@gmail.com", 
				"Welcome to Subject Email API",
				MailTemplate.getTemplateData("Vikram", "Vineeth", "Armoori"));
		if(sent) {
			System.out.println("MAIL SENT");
		}
		else {
			System.out.println("NOT SENT");
		}
	}

}

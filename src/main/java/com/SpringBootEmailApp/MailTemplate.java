package com.SpringBootEmailApp;

import java.io.FileInputStream;

public class MailTemplate {
	
	private static String template=null;
	static {
		try {
			FileInputStream fis=new FileInputStream("F:\\SpringBoot Videos\\Raghu Sir MS Video\\Notes\\mailtemplate.txt");
			byte[] bytes=new byte[fis.available()];
			fis.read(bytes);
			template=new String(bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static String getTemplate() {
		return template;
	}
	public static String getTemplateData(String user, String fn, String ln) {
		String template=getTemplate();
		
		template=template.replace("{{user}}", "Vikarm")
		.replace("{{Firstname}}", "Vineeth")
		.replace("{{Lastname}}", "Armoori")
		.replace("{{date}}", new java.util.Date().toString());
		
		System.out.println(template);
		return template;
	}
}

package com.ps21510.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ps21510.service.MailerService;



@Controller
public class MailerController {
	@Autowired
	MailerService mailer;

	@ResponseBody
	@RequestMapping("/mailer/demo1")
	public String demo1(Model model) {
		try {
			mailer.send("khuongvlps21510@fpt.edu.vn", "Subject", "Body");			
			return "OK";
		} catch (MessagingException e) {
			return e.getMessage();
		}
	}
	
	@ResponseBody
	@RequestMapping("/mailer/demo2")
	public String demo2(Model model) {		
			mailer.queue("tanntps21613@fpt.edu.vn", "Subject1", "Body1");
			mailer.queue("nguyentrongban01052003@gmail.com", "Subject2", "Body2");
			mailer.queue("thangtqps15783@fpt.edu.vn", "Subject2", "Body2");
			mailer.queue("phuongvddps16207@fpt.edu.vn", "Subject2", "Body2");
			mailer.queue("duynhps18293@fpt.edu.vn", "Subject2", "Body2");
			return "Queue OK";		
	}
}


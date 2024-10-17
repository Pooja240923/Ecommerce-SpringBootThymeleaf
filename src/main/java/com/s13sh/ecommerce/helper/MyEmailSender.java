package com.s13sh.ecommerce.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.s13sh.ecommerce.dto.Seller;

import jakarta.mail.internet.MimeMessage;

@Service
public class MyEmailSender {
	
	@Autowired
	JavaMailSender mailSender;

	public void sendOtp(Seller seller) {
		MimeMessage message=mailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message);
		try {
		helper.setFrom("saishkulkarni7@gmail.com","Ecommerce Site");
		helper.setTo(seller.getEmail());
		helper.setSubject("Otp for Account Creation");
		helper.setText("<h1>Hello "+seller.getName()+"</h1><h3>Your OTP is : "+seller.getOtp()+"</h3>",true);
		mailSender.send(message);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("**************"+seller.getOtp()+"***********************");
	}

}

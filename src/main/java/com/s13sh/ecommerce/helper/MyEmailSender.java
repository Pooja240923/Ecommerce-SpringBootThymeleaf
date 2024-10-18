package com.s13sh.ecommerce.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.s13sh.ecommerce.dto.Seller;

import jakarta.mail.internet.MimeMessage;

@Service
public class MyEmailSender {

	@Autowired
	JavaMailSender mailSender;

	@Autowired
	TemplateEngine templateEngine;

	public void sendOtp(Seller seller) {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		try {
			helper.setFrom("saishkulkarni7@gmail.com", "Ecommerce Site");
			helper.setTo(seller.getEmail());
			helper.setSubject("Otp for Account Creation");

			Context context = new Context();
			context.setVariable("seller", seller);

			String text = templateEngine.process("seller-email.html", context);
			helper.setText(text, true);
			
			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("**************" + seller.getOtp() + "***********************");
	}

}

package com.s13sh.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.s13sh.ecommerce.dto.Seller;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/seller")
public class SellerController {
	
	@Autowired
	Seller seller;

	@GetMapping("/register")
	public String loadRegister(ModelMap map) {
		map.put("seller",seller);
		return "seller-register.html";
	}
	
	@PostMapping("/register")
	public String register(@Valid Seller seller,BindingResult result) {
	
		if(result.hasErrors())
			return "seller-register.html";
		else
			return "redirect:https://www.youtube.com";
	}
	
}

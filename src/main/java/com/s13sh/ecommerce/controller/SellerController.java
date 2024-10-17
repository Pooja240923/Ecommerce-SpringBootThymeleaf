package com.s13sh.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.s13sh.ecommerce.dto.Seller;
import com.s13sh.ecommerce.service.SellerService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/seller")
public class SellerController {
	
	@Autowired
	SellerService sellerService;

	@GetMapping("/register")
	public String loadRegister(ModelMap map) {
		return sellerService.loadRegister(map);
	}
	
	@PostMapping("/register")
	public String register(@Valid Seller seller,BindingResult result,ModelMap map) {
		return sellerService.loadRegister(seller,result,map);
	}
	
	@PostMapping("/submit-otp/{id}")
	public String submitOtp(@PathVariable int id,@RequestParam int otp,ModelMap map) {
		return sellerService.submitOtp(id,otp,map);
	}
	
}

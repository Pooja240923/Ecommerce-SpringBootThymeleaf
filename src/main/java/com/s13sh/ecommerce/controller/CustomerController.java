package com.s13sh.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@GetMapping("/register")
	public String loadRegister() {
		return "customer-register.html";
	}
}

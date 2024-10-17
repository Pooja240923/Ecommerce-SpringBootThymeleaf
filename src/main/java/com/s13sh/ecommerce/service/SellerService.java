package com.s13sh.ecommerce.service;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import com.s13sh.ecommerce.dto.Seller;

public interface SellerService {

	String loadRegister(ModelMap map);

	String loadRegister(Seller seller, BindingResult result, ModelMap map);

	String submitOtp(int id, int otp, ModelMap map);

}

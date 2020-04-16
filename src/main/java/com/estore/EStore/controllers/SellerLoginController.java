/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estore.EStore.controllers;

import com.estore.EStore.Services.SellerService;
import com.estore.EStore.models.Customer;
import com.estore.EStore.models.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Yash Patel
 */

@Controller
public class SellerLoginController {
        
        @Autowired
        private SellerService sellerService;
    
    
        @RequestMapping("/seller")
	public String admin() {
		return "redirect:seller/login";
	}

	@RequestMapping("/seller/login")
	public String adminlogin() {
		return "seller/login";
	}

	@RequestMapping("/seller/dashboard")
	public String admindashboard(ModelMap model,@AuthenticationPrincipal Seller seller) {
            model.put("seller", seller);
            
		return "seller/dashboard";
	}
        
        @RequestMapping("/seller/register")
        public String sellerRegister(ModelMap model){
               model.put("seller",new Seller());
               return "seller/register";
        }
        
        @PostMapping("/seller/register")
        public String saveCustomer(@ModelAttribute Seller seller){
            sellerService.save(seller);
            return "redirect:/seller/login";
        }
 
}

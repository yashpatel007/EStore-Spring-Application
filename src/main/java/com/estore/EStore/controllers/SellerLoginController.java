/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estore.EStore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Yash Patel
 */

@Controller
public class SellerLoginController {
  
    @RequestMapping("/seller")
	public String admin() {
            System.out.println("there here");
		return "redirect:seller/login";
	}

	@RequestMapping("/seller/login")
	public String adminlogin() {
		return "seller/login";
	}

	@RequestMapping("/seller/dashboard")
	public String admindashboard() {
		return "seller/dashboard";
	}
 
}

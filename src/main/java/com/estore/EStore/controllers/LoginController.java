/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estore.EStore.controllers;

import com.estore.EStore.Repositories.CustomerRepository;
import com.estore.EStore.Services.CustomerService;
import com.estore.EStore.models.Customer;
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
public class LoginController {
    
    
    //===========================GET MAPPINGS=========================
    
    
    @Autowired
    private CustomerService customerService;
    
    
    
    
    @RequestMapping("/")
    public String homePage(ModelMap model,@AuthenticationPrincipal Customer customer){
        // request to home page mapped to index.html
        System.out.println(customer);
        model.put("customer",customer);
        return "index";
    }
    
    @RequestMapping("/login")
    public String loginPage(){
        return "login";
    }
    
    
    @RequestMapping("/register")
    public String registerPage(ModelMap model){
        //put an empty customer
        model.put("customer", new Customer());
        return "register";
    }
    
    @RequestMapping("/sellerregister")
    public String sellerRegisterPage(){
        return "sellerregister";
    }
    
    
    @PostMapping("/register")
    public String saveCustomer(@ModelAttribute Customer customer){
        System.out.println("mapping==> "+customer);
        customerService.save(customer);
        return "redirect:/login";
    }
    
    
    
    
    
}

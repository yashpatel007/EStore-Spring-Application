/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estore.EStore.controllers;

import com.estore.EStore.models.Customer;
import org.springframework.stereotype.Controller;
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
    
    @RequestMapping("/")
    public String homePage(){
        // request to home page mapped to index.html
        return "index";
    }
    
    @RequestMapping("/login")
    public String loginPage(){
        return "login";
    }
    
    
    @RequestMapping("/register")
    public String registerPage(){
        return "register";
    }
    
    @RequestMapping("/sellerregister")
    public String sellerRegisterPage(){
        return "sellerregister";
    }
    
    
    
    
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estore.EStore.controllers;

import com.estore.EStore.Repositories.CartRepository;
import com.estore.EStore.Services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Yash Patel
 */


@Controller
public class CartController {
    
    @Autowired
    private CartRepository cartRepo;
    
    @Autowired
    private CartService cartService;
    
    @PostMapping("/deletecartitem")
    public String delProductFromCart(@ModelAttribute(name="productId") Long productId, @ModelAttribute(name="customerId") Long customerId){
        
        cartService.deleteFromCart(customerId,productId);
        
        return "redirect:cart";
    
    }
    
    
    
    
    
}

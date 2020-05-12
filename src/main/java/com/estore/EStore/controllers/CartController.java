/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estore.EStore.controllers;

import com.estore.EStore.Repositories.CartRepository;
import com.estore.EStore.Services.CartService;
import com.estore.EStore.Services.OrderService;
import com.estore.EStore.models.Customer;
import com.estore.EStore.models.Orders;
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
public class CartController {
    
    @Autowired
    private CartRepository cartRepo;
    
    @Autowired
    private CartService cartService;
    
    @Autowired
    private OrderService orderService;
    
    @RequestMapping("/orders")
    public String showOrders(ModelMap model, @AuthenticationPrincipal Customer customer){
        // info for header
        model.put("customer", customer);
        model.put("cartcount", cartRepo.getcartCount(customer.getId()));
        // for the orders page
        model.put("myorders", orderService.getMyOrders(customer.getId()));
        
        
        return "orders";
    }
    
    @PostMapping("/deletecartitem")
    public String delProductFromCart(@ModelAttribute(name="productId") Long productId, @ModelAttribute(name="customerId") Long customerId){
        
        cartService.deleteFromCart(customerId,productId);
        
        return "redirect:cart";
    }
    
    @PostMapping("/placeorder")
    public String placeOrder(@AuthenticationPrincipal Customer customer){
    
        cartService.placeMyOrder(customer.getId());
        return "redirect:cart";
    } 
    
    @PostMapping("/deleteorder")
    public String deleteOrder(@ModelAttribute(name="orderid") Long orderId){
        
//        System.out.println(orderId);
        orderService.deleteOrder(orderId);
        return "redirect:orders";
    }
   
    @PostMapping("/increseItem")
    private String addTOcart(@ModelAttribute(name="productId") Long productId, @AuthenticationPrincipal Customer customer){
        cartService.addtoCart(customer, productId,1);
        return "redirect:cart";
    }
    
    @PostMapping("/decreseItem")
    private String remFromcart(@ModelAttribute(name="productId") Long productId, @AuthenticationPrincipal Customer customer){
        cartService.addtoCart(customer, productId,-1);
        return "redirect:cart";
    }
    
}
 
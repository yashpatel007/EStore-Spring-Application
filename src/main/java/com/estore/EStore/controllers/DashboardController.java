/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estore.EStore.controllers;

import com.estore.EStore.Repositories.CartRepository;
import com.estore.EStore.Repositories.ProductRepository;
import com.estore.EStore.models.Cart;
import com.estore.EStore.models.Customer;
import com.estore.EStore.models.Orders;
import com.estore.EStore.models.Product;
import java.util.List;
import java.util.Optional;
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
public class DashboardController {
    
    @Autowired
    private ProductRepository productRepo;
    
    @Autowired
    private  CartRepository cartRepo;
    
    
    @RequestMapping("/dashboard")
    public String showDashboard(ModelMap model,@AuthenticationPrincipal Customer customer){
        // dashboard knows who the customer is 
        model.put("customer", customer);
        
        model.put("order",new Orders());
        // get all the products or some products randomly
        List<Product> randProds = productRepo.findAll();
        
        if(randProds != null){
            model.put("randProducts", randProds);
        }

        
        
        return "dashboard";
    }
    
    
     @PostMapping("/tocart")
     private String tocart(@ModelAttribute(name="productId") Long productId, @AuthenticationPrincipal Customer customer){
        Cart cart = new Cart();
         
        cart.setCustomer_id(customer.getId());
        Optional<Product> product = productRepo.findById(productId);
        if(product.isPresent()){
            cart.setProduct(product.get());
        }
        
        cartRepo.save(cart);
        
         return "redirect:dashboard";
     }
    
    
}

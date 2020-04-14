/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estore.EStore.controllers;

import com.estore.EStore.Repositories.ProductRepository;
import com.estore.EStore.models.Customer;
import com.estore.EStore.models.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Yash Patel
 */

@Controller
public class DashboardController {
    
    @Autowired
    private ProductRepository productRepo;
    
    @RequestMapping("/dashboard")
    public String showDashboard(ModelMap model,@AuthenticationPrincipal Customer customer){
        // dashboard knows who the customer is 
        model.put("customer", customer);
        
        
        // get all the products or some products randomly
        List<Product> randProds = productRepo.findAll();
        
        if(randProds != null){
            model.put("randProducts", randProds);
        }

        
        
        return "dashboard";
    }
    
    
}

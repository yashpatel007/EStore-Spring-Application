/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estore.EStore.controllers;

import com.estore.EStore.Services.CategoriesService;
import com.estore.EStore.Services.ProductService;
import com.estore.EStore.models.Orders;
import com.estore.EStore.models.Product;
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
public class SellerDashboardController {

    @Autowired
    private ProductService productService;
    
    @Autowired
    private CategoriesService categoriesService;
    
    
     @RequestMapping("/seller/createproduct")
     private String createProduct(ModelMap model,@AuthenticationPrincipal Seller seller){
         model.put("seller", seller);
         model.put("product", new Product());
         model.put("categories", categoriesService.getCategories());
         
         return "seller/createproduct";
     }
        
     @PostMapping("/seller/createproduct")
     private String svprod(@ModelAttribute Product product, @AuthenticationPrincipal Seller seller){
         product.setSeller(seller);
         
         productService.save(product);
         return "redirect:createproduct";
     }
     
     
     @RequestMapping("/seller/dashboard")
	public String admindashboard(ModelMap model,@AuthenticationPrincipal Seller seller) {
            model.put("seller", seller);
            return "seller/dashboard";
	}
     

}

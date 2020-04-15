/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estore.EStore.Services;

import com.estore.EStore.Repositories.SellerRepository;
import com.estore.EStore.models.Authority;
import com.estore.EStore.models.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Yash Patel
 */
@Service
public class SellerService {
   
    @Autowired
    private SellerRepository sellerRepo;
    
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    
    public Seller save(Seller seller){
        
        System.out.println(seller);
//        String encodedPassword = passwordEncoder.encode(seller.getPassword());
//        seller.setPassword(encodedPassword);
//        Authority authority = new Authority();
//        authority.setAuthority("ROLE_SELLER");
//        authority.setCustomer(seller);
//        seller.getAuthorities().add(authority);
          //return sellerRepo.save(seller);
          return null;
    }
    
    
    
    
}

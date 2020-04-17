/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estore.EStore.Services;

import com.estore.EStore.Repositories.CartRepository;
import com.estore.EStore.Repositories.CustomerRepository;
import com.estore.EStore.models.Authority;
import com.estore.EStore.models.Cart;
import com.estore.EStore.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Yash Patel
 */

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepo;
    
    @Autowired
    private CartRepository cartRepo;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    
    public Customer save(Customer customer){
        
        System.out.println(customer);
        String encodedPassword = passwordEncoder.encode(customer.getPassword());
        customer.setPassword(encodedPassword);
        
        //create empty cart for customers
        
        Authority authority = new Authority();
        customer.getAuthorities().add(authority);
        authority.setAuthority("ROLE_USER");
        authority.setCustomer(customer);
        
       return customerRepo.save(customer);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estore.EStore.Services;

import com.estore.EStore.Repositories.CustomerRepository;
import com.estore.EStore.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Yash Patel
 */
@Service
public class CustomerDetailsServiceImpl  implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepo;
     
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       
     Customer customer = customerRepo.findByUsername(username);
        
        if(customer ==null){
            throw new UsernameNotFoundException("Invalid Username and Password");
        }
        // this is tightly coupling with spring userdetail service
        return customer;
    }
    
}

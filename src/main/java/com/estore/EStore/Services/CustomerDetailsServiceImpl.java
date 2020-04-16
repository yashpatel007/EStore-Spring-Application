/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estore.EStore.Services;

import com.estore.EStore.Repositories.CustomerRepository;
import com.estore.EStore.Repositories.SellerRepository;
import com.estore.EStore.models.Customer;
import com.estore.EStore.models.Seller;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author Yash Patel
 */
@Service
public class CustomerDetailsServiceImpl  implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepo;
     
    @Autowired
    private SellerRepository sellerRepository;
    
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       
     Customer customer = customerRepo.findByUsername(username);
     Seller seller = sellerRepository.findByUsername(username);
     
        System.out.println("base url:"+getBaseUrl()+" full url: "+getcurrURL());
        if(customer !=null && seller ==null){
            return customer; 
        }else if(customer==null && seller !=null){
            return seller;
        }else if(customer!=null && seller !=null){
            if(getcurrURL().equals(getBaseUrl()+"/login")){
                return customer;
            }else{ 
                return seller;
            }
        }else{
            throw new UsernameNotFoundException("Invalid Username and Password");
        }
        
    }
    
    
    private String getcurrURL(){
    ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequestUri();
    builder.scheme("http");
    URI newUri = builder.build().toUri();
    return newUri.toString();
    }
    
    private String getBaseUrl(){
        
        final String baseUrl = 
        ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        return baseUrl;
    
    }
    
    
    
    
}

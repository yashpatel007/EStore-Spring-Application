/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estore.EStore.security;

import com.estore.EStore.models.Customer;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Yash Patel
 */
public class CustomSecurityUser extends Customer implements UserDetails{

    
    
     public CustomSecurityUser(){}
    
    public CustomSecurityUser(Customer customer) {
        this.setAuthorities(customer.getAuthorities());
        this.setId(customer.getId());
        this.setName(customer.getName());
        this.setPassword(customer.getPassword());
        this.setEmail(customer.getEmail());
    }
    
    
    @Override
    public String getUsername() {
        return super.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estore.EStore.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author Yash Patel
 */

@Entity
public class SellerAuthority implements GrantedAuthority{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String authority;
    
    @ManyToOne(targetEntity = Seller.class)
    private Seller seller;
    
    
    public void setAuthority(String authority) {
        this.authority = authority;
    }
    
    
    @Override
    public String getAuthority() {
        return this.authority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
    
    
    
}

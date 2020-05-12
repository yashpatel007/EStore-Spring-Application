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

/**
 *
 * @author Yash Patel
 */
@Entity
public class Categories {
    
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }    
}

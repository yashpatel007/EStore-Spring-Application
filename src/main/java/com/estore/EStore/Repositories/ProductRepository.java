/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estore.EStore.Repositories;


import com.estore.EStore.models.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Yash Patel
 */


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    
    
    
}

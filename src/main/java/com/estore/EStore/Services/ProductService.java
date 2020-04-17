/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estore.EStore.Services;

import com.estore.EStore.Repositories.ProductRepository;
import com.estore.EStore.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Yash Patel
 */


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    
    public Product save(Product product){
        productRepository.save(product);
        return product;
    }


    
}

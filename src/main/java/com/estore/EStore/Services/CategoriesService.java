/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estore.EStore.Services;


import com.estore.EStore.Repositories.CatrgoriesRepository;
import com.estore.EStore.models.Categories;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Yash Patel
 */
@Service
public class CategoriesService {
    
    @Autowired
    private CatrgoriesRepository categoriesRepo;
    
    
    public List<Categories> getCategories(){
         return  categoriesRepo.findAll();
    }
    
}

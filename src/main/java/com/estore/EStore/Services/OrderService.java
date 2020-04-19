/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estore.EStore.Services;

import com.estore.EStore.Repositories.OrdersRepository;
import com.estore.EStore.Repositories.ProductRepository;
import com.estore.EStore.models.Orders;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Yash Patel
 */


@Service
public class OrderService {
    
    @Autowired 
    private OrdersRepository orderRepo;
    
    
    public List<Orders> getMyOrders(Long cid){
        
        return orderRepo.getMyOrders(cid);
        
    }
    
    
    
    
}

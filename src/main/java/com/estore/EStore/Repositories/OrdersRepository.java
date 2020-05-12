/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estore.EStore.Repositories;

import com.estore.EStore.models.Orders;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Yash Patel
 */
@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
   
    
    @Query(value = "SELECT * FROM orders o WHERE o.customer_id=:cid",
            nativeQuery = true)
    public List<Orders> getMyOrders(Long cid);
    
    
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value ="DELETE FROM orders where id=:oid",
            nativeQuery = true)
    public void deleteOrder(Long oid);
    
    
}

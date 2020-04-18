/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estore.EStore.Repositories;

import com.estore.EStore.models.Cart;
import com.estore.EStore.models.Customer;
import com.estore.EStore.models.Product;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Yash Patel
 */

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    
   
    @Query(value = "Select sum(c.count) from cart c where c.customer_id=:cid", nativeQuery= true)
    Long getcartCount(Long cid);
    
    @Query(value = "SELECT count(c.customer_id) FROM cart c WHERE c.customer_id=:cid and c.product_id=:pid" , nativeQuery = true)
    Long ifCustomerHaveProduct(Long cid, Long pid);
    
    @Transactional 
    @Modifying(clearAutomatically = true)
    @Query(value="Update cart c set c.count=c.count+1 where customer_id=:cid and product_id=:pid", nativeQuery = true )
    void updateCount(Long cid, Long pid); 
    
    @Query(value = "SELECT * FROM Cart c WHERE  c.customer_id=:cid", nativeQuery = true)
    List<Cart> getMyCartItems(Long cid);
    
    
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "Delete from cart where customer_id=:cid and product_id=:pid",nativeQuery = true)
    void deleteCartItem(Long cid, Long pid);
    
}

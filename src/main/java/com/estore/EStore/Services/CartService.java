/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estore.EStore.Services;

import com.estore.EStore.Repositories.CartRepository;
import com.estore.EStore.Repositories.ProductRepository;
import com.estore.EStore.models.Cart;
import com.estore.EStore.models.Customer;
import com.estore.EStore.models.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

/**
 *
 * @author Yash Patel
 */

@Service
public class CartService {
    
    
    @Autowired
    private ProductRepository productRepo;
    
    @Autowired
    private CartRepository cartRepo;
    
    
    public Cart addtoCart(@AuthenticationPrincipal Customer customer, Long productId){
        
//        System.out.println("================================");
//        // see if entry already exist
//        System.out.println(cartRepo.getcartCount(customer.getId()));
//        System.out.println("================================");
//        
//        System.out.println("================cartitems================");
//        
//        List<Cart> cartitems=cartRepo.getMyCartItems(customer.getId());
//        for (Cart item: cartitems){
//            System.out.println(item.getProduct().getName());
//        }
//        
//        
//        System.out.println("================================");
        
        Long prodInCart = cartRepo.ifCustomerHaveProduct(customer.getId(), productId);
        if(prodInCart>0){
            // update count+1
            cartRepo.updateCount(customer.getId(), productId);
        }else{
        
        Cart cart = new Cart();
         
        cart.setCustomer(customer);
        Optional<Product> product = productRepo.findById(productId);
        if(product.isPresent()){
            cart.setProduct(product.get());
            cart.setCount(1);
            }
            return cartRepo.save(cart);
        }
        return null;
    }
    
    
    public void deleteFromCart(Long cid, Long pid){
    
        cartRepo.deleteCartItem(cid, pid);
    
    }
    
    
    
    
    
}

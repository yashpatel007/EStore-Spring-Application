/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estore.EStore.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author Yash Patel
 */

@Configuration
@Order(1)
public class WebSecurityConfigSeller extends WebSecurityConfigurerAdapter {
    
    
    @Autowired
    private UserDetailsService userDetailsService;
     
     public PasswordEncoder getPasswordEncoder(){
        return  new BCryptPasswordEncoder();
     }
     
     @Override
     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            
         auth.userDetailsService(userDetailsService)
                .passwordEncoder(getPasswordEncoder());
         
         
//                auth.inMemoryAuthentication()
//                .passwordEncoder(getPasswordEncoder())
//                .withUser("ps@mail.com")
//                .password( getPasswordEncoder().encode("asdfasdf"))
//                .roles("SELLER");
      }
     
      @Override
      protected void configure(HttpSecurity http) throws Exception {
                    http 
                    .antMatcher("/seller/**")
			.authorizeRequests().antMatchers("/seller/register").permitAll()
                        .anyRequest().authenticated()
			.and().formLogin().loginPage("/seller/login")
                        .defaultSuccessUrl("/seller/dashboard")
			.permitAll()
			.and().logout().logoutUrl("/seller/logout").logoutSuccessUrl("/seller/login");
                    
    }
 
}

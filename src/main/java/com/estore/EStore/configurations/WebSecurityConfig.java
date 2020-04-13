/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estore.EStore.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author Yash Patel
 */

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
     @Bean
     public PasswordEncoder getPasswordEncoder(){
        return  new BCryptPasswordEncoder();
     }
     
     @Override
     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
     
        auth.inMemoryAuthentication()
                .passwordEncoder(getPasswordEncoder())
                .withUser("yp@mail.com")
                .password( getPasswordEncoder().encode("asdfasdf"))
                .roles("USER");  
      }
      @Override
      protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers("/images/**").permitAll()
                    .antMatchers("/register").permitAll()
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .anyRequest().hasRole("USER").and()
                    .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/dashboard")
                    .permitAll()
                    .and()
                    .logout().logoutUrl("/logout")
                    .permitAll();
                    
    }
     
    
    
    
    
}

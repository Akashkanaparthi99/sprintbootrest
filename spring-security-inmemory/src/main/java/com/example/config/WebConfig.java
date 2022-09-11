package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebConfig extends WebSecurityConfigurerAdapter {
   // do authentication

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // to do inmemory authentication
        // hardcode the username and password
        auth.inMemoryAuthentication()
                .withUser("Akash")
                .password(passwordEncoder().encode("Ash@123"))
                .roles("USER")
                .and()
                .withUser("James")
                .password(passwordEncoder().encode("admin123"))
                .roles("ADMIN","USER");
    }
    // to encode the password , we use BCryptPasswordEncoder
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/")
                .permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/products/**").hasAnyRole("ADMIN","USER")
                .and()
                .formLogin();
    }
}

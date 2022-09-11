package com.productapp.service;

import com.productapp.model.JWTUser;
import com.productapp.repository.IJWTUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Service
public class JWTUserServiceImpl implements UserDetailsService {

    @Autowired
    private IJWTUserRepository ijwtUserRepository;
    public void addUser(JWTUser user){
        ijwtUserRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        JWTUser user = ijwtUserRepository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("Invalid username");
        // create the roles and authorities
        List<GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("ADMIN"),new SimpleGrantedAuthority("USER"));

        //create the inbuilt user object using the data
        UserDetails userDetails = new User(user.getUsername(),user.getPassword(),authorities);

        return userDetails;
    }
}

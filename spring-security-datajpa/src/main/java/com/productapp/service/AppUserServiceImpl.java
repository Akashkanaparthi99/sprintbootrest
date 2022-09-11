package com.productapp.service;

import com.productapp.model.AppUser;
import com.productapp.repository.IAppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
@Service
public class AppUserServiceImpl implements UserDetailsService,IAppUserService{

    private IAppUserRepository appUserRepository;


    @Autowired
    public void setAppUserRepository(IAppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByUsername(username);
        // Assign to username and password
        String nusername = appUser.getUsername();
        String password = appUser.getPassword();
        // create authorities - roles
        GrantedAuthority grantedAuthority1 = new SimpleGrantedAuthority("USER");
        GrantedAuthority grantedAuthority2 = new SimpleGrantedAuthority("ADMIN");
        // create an object of the inbuilt class user to match the return type
        // interface ref = inbuilt class
        UserDetails user = new User(nusername,password, Arrays.asList(grantedAuthority1,grantedAuthority2));
        // if user is available return the user
        return user;
    }

    @Override
    public void addUser(AppUser user) {

        appUserRepository.save(user);
    }

    @Override
    public void updateUser(AppUser user) {
        appUserRepository.save(user);
    }

    @Override
    public void deleteUser(int userId) {
        appUserRepository.deleteById(userId);
    }
}

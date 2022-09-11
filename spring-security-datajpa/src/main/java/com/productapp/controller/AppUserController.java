package com.productapp.controller;

import com.productapp.model.AppUser;
import com.productapp.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppUserController {
    private PasswordEncoder passwordEncoder;
    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    private IAppUserService appUserService;
    @Autowired
    public void setAppUserService(IAppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @PostMapping("/")
    public void addUser(@RequestBody AppUser user){
        // to encode the password using the password encoder
        String password = passwordEncoder.encode(user.getPassword());

        String username = user.getUsername();
        // create the appuser object
        AppUser appUser = new AppUser(username,password);
        appUserService.addUser(appUser);
    }
    @GetMapping("/")
    public String addUser(){
        return "have a great day";
    }
}

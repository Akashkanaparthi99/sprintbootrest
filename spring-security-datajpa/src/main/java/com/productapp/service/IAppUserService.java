package com.productapp.service;

import com.productapp.model.AppUser;

public interface IAppUserService {
    void addUser(AppUser user);
    void updateUser(AppUser user);
    void deleteUser(int userId);
}

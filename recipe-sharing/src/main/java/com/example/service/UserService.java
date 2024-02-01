package com.example.service;

import com.example.model.User;

public interface UserService {

    public User findUserById(Long id) throws Exception;

    public User findUserByJwt(String jwt) throws Exception;
    
}

package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.config.JwtProvider;
import com.example.model.User;
import com.example.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService{
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public User findUserById(Long id) throws Exception {
        
       Optional<User> opt = userRepository.findById(id);

         if(opt.isPresent()){
              return opt.get();
         }

        throw new Exception("User not found with id "+id);
    }

    @Override
    public User findUserByJwt(String jwt) throws Exception {
        
        String email = jwtProvider.getEmailFromJwtToken(jwt);

        if(email == null){
            throw new Exception("Provide valid token");
        }

        User user = userRepository.findByEmail(email);

        if(user == null){
            throw new Exception("User not found with email "+email);
        }

        return user;
    }
}

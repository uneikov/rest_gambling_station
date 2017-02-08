package com.uran.rest_gambling_station.service;

import com.uran.rest_gambling_station.AuthorizedUser;
import com.uran.rest_gambling_station.domain.User;
import com.uran.rest_gambling_station.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "userService")
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository repository;
    
    @Override
    public List<User> findAll() {
        return this.repository.findAll();
    }
   
    @Override
    public AuthorizedUser loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repository.findByEmailIgnoringCase(email);
        if (user == null) {
            throw new UsernameNotFoundException("User " + email + " is not found");
        }
        return new AuthorizedUser(user);
    }
}

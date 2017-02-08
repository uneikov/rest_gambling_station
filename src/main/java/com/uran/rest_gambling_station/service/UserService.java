package com.uran.rest_gambling_station.service;

import com.uran.rest_gambling_station.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService{
    List<User> findAll();
}

package com.uran.rest_gambling_station.service;

import com.uran.rest_gambling_station.domain.User;
import com.uran.rest_gambling_station.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService{
    List<User> findAll();
    User findOne(long id);
    User save(User user);
    void delete(long id);
    User findByEmail(String email);
    void enable(long id, boolean enabled);
    void update(UserDto userDto);
    void update(User user);
}

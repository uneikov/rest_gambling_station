package com.uran.rest_gambling_station.service;

import com.uran.rest_gambling_station.AuthorizedUser;
import com.uran.rest_gambling_station.domain.User;
import com.uran.rest_gambling_station.dto.UserDto;
import com.uran.rest_gambling_station.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

import static com.uran.rest_gambling_station.util.user.UserUtil.*;

@Component(value = "userService")
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository repository;
    
    @Override
    public List<User> findAll() {
        return this.repository.findAll();
    }
    
    @Override
    public User findOne(long id) {
        return this.repository.findOne(id);
    }
    
    @Override
    public User save(User user) {
        Assert.notNull(user, "user must not be null");
        return this.repository.save(user);
    }
    
    @Override
    public void delete(long id) {
        this.repository.delete(id);
    }
    
    @Override
    public User findByEmail(String email) {
        return this.repository.findByEmailIgnoringCase(email);
    }
    
    @Override
    @Transactional
    public void enable(long id, boolean enabled) {
        User user = this.repository.findOne(id);
        user.setEnabled(enabled);
        this.repository.save(user);
    }
    
    @Override
    @Transactional
    public void update(UserDto userDto) {
        User user = updateFromTo(this.repository.findOne(userDto.getId()), userDto);
        this.repository.save(prepareToSave(user));
    }
    
    @Override
    public void update(User user) {
        Assert.notNull(user, "user must not be null");
        this.repository.save(prepareToSave(user));
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

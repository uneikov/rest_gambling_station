package com.uran.rest_gambling_station.web;

import com.uran.rest_gambling_station.domain.User;
import com.uran.rest_gambling_station.dto.UserDto;
import com.uran.rest_gambling_station.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class AbstractUserController {
    private final Logger log = LoggerFactory.getLogger(AbstractUserController.class);
    
    @Autowired
    private UserService userService;
    
    public List<User> getAll() {
        log.info("getAll");
        return this.userService.findAll();
    }
    
    public User get(final long id) {
        log.info("get " + id);
        return this.userService.findOne(id);
    }
    
    @Transactional
    User create(final User user) {
        user.setId(null);
        log.info("create " + user);
        return this.userService.save(user);
    }
    
    public void delete(final long id) {
        log.info("delete " + id);
        this.userService.delete(id);
    }
    
    public void update(final User user, final long id) {
        user.setId(id);
        log.info("update " + user);
        this.userService.update(user);
    }
    
    public void update(final UserDto userDto) {
        log.info("update " + userDto);
        this.userService.update(userDto);
    }
    
    public User getByMail(final String email) {
        log.info("getByEmail " + email);
        return this.userService.findByEmail(email);
    }
    
    void enable(final long id, final boolean enabled) {
        log.info((enabled ? "enable " : "disable ") + id);
        this.userService.enable(id, enabled);
    }
}

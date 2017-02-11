package com.uran.rest_gambling_station.web;

import com.uran.rest_gambling_station.AuthorizedUser;
import com.uran.rest_gambling_station.domain.User;
import com.uran.rest_gambling_station.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(ProfileRestController.REST_URL)
public class ProfileRestController extends AbstractUserController{
    protected static final String REST_URL = "/profile";
    
    @GetMapping(produces = APPLICATION_JSON_UTF8_VALUE)
    public User get() {
        return super.get(AuthorizedUser.id());
    }
    
    @DeleteMapping
    public void delete() {
        super.delete(AuthorizedUser.id());
    }
    
    @Override
    @PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    public void update(@Valid @RequestBody final UserDto userDto) {
        userDto.setId(AuthorizedUser.id());
        super.update(userDto);
    }
}

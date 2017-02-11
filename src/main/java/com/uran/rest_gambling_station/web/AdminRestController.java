package com.uran.rest_gambling_station.web;

import com.uran.rest_gambling_station.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(AdminRestController.REST_URL)
public class AdminRestController extends AbstractUserController{
    protected static final String REST_URL = "/admin/users";
    
    @Override
    @GetMapping(produces = APPLICATION_JSON_UTF8_VALUE)
    public List<User> getAll() {
        return super.getAll();
    }
    
    @Override
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    public User get(@PathVariable("id") final long id) {
            return super.get(id);
    }
    
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> createWithLocation(@Valid @RequestBody final User user) {
        User created = super.create(user);
        
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        
        return ResponseEntity.created(uriOfNewResource).body(created);
    }
    
    @Override
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") final long id) {
        super.delete(id);
    }
    
    @Override
    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_UTF8_VALUE)
    public void update(@Valid @RequestBody final User user, @PathVariable("id") final long id) {
        super.update(user, id);
    }
    
    @Override
    @GetMapping(value = "/by", produces = APPLICATION_JSON_UTF8_VALUE)
    public User getByMail(@RequestParam("email") final String email) {
        return super.getByMail(email);
    }
    
    @Override
    @PostMapping(value = "/{id}")
    public void enable(@PathVariable("id") final long id, @RequestParam("enabled") final boolean enabled) {
        super.enable(id, enabled);
    }
    
}

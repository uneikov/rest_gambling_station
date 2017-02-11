package com.uran.rest_gambling_station.web;

import com.uran.rest_gambling_station.domain.Stake;
import com.uran.rest_gambling_station.service.StakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.uran.rest_gambling_station.AuthorizedUser.id;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping("/stakes")
public class StakeRestController {
    
    @Autowired
    private StakeService service;
    
    @GetMapping(value = "/all", produces = APPLICATION_JSON_UTF8_VALUE)
    public List<Stake> getAll() {
        //System.out.println(p.getName()); Principal p
        return this.service.findAll(new PageRequest(0, 10)).getContent();
    }
    
    @GetMapping(produces = APPLICATION_JSON_UTF8_VALUE)
    public List<Stake> getAllForAuthorizedUser() {
        return this.service.findAllByUserId(id(), new PageRequest(0, 10)).getContent();
    }
    
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    public Stake get(@PathVariable("id") final Long id) {
        return this.service.findById(id);
    }
    
}

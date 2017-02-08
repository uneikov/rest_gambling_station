package com.uran.rest_gambling_station.web;

import com.uran.rest_gambling_station.domain.Stake;
import com.uran.rest_gambling_station.service.StakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
public class StakeRestController {
    
    @Autowired
    private StakeService service;
    
    @GetMapping(value = "/stakes", produces = APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<Stake> getAll(Principal p) {
        System.out.println(p.getName());
        return this.service.findAll(new PageRequest(0, 10)).getContent();
    }
    
    @GetMapping(value = "/stakes/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Stake get(@PathVariable("id") final Long id) {
        return this.service.findById(id);
    }
    
    @GetMapping(value = "/race/{id}/stakes", produces = APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<Stake> getWithRaceId(@PathVariable("id") final Long id) {
        return this.service.findAllByRaceId(id, new PageRequest(0, 10)).getContent();
    }
    
}

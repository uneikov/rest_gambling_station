package com.uran.rest_gambling_station.web;

import com.uran.rest_gambling_station.domain.Horse;
import com.uran.rest_gambling_station.service.HorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
public class RootController {
    
    @Autowired
    private HorseService horseService;
    
    @RequestMapping("/")
    public @ResponseBody
    String greeting() {
        return "Hello World";
    }
    
    @GetMapping(value = "/horses", produces = APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<Horse> getHorses() {
        return this.horseService.findAll(new PageRequest(0, 10)).getContent();
    }
    
    @GetMapping(value = "/horses/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Horse getHorse(@PathVariable("id") final Long id) {
        return this.horseService.findById(id);
    }
    
}

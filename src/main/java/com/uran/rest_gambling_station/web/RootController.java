package com.uran.rest_gambling_station.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {
    
    @RequestMapping("/")
    public @ResponseBody
    String greeting() {
        return "Hello World";
    }
    
}

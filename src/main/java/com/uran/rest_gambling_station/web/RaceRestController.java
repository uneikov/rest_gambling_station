package com.uran.rest_gambling_station.web;

import com.uran.rest_gambling_station.domain.Race;
import com.uran.rest_gambling_station.domain.Stake;
import com.uran.rest_gambling_station.service.RaceService;
import com.uran.rest_gambling_station.service.StakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(value = "/races")
public class RaceRestController {
    
    @Autowired
    private RaceService raceService;
    
    @Autowired
    private StakeService stakeService;
    
    @GetMapping(produces = APPLICATION_JSON_UTF8_VALUE)
    public List<Race> getAll() {
        return this.raceService.findAll();
    }
    
    @GetMapping(value = "raceId", produces = APPLICATION_JSON_UTF8_VALUE)
    public Race getRace(@PathVariable("raceId") final long raceId) {
        return this.raceService.findById(raceId);
    }
    
    @GetMapping(value = "/{raceId}/stakes", produces = APPLICATION_JSON_UTF8_VALUE)
    public List<Stake> getWithRaceId(@PathVariable("raceId") final Long raceId) {
        return this.stakeService.findAllByRaceId(raceId, new PageRequest(0, 10)).getContent();
    }
    
    @GetMapping(value = "/{raceId}/stakes/{userId}", produces = APPLICATION_JSON_UTF8_VALUE)
    public List<Stake> getWithRaceIdAndUserId(
            @PathVariable("raceId") final Long raceId,
            @PathVariable("userId") final long userId) {
        return this.stakeService.findAllByRaceIdUserId(raceId, userId, new PageRequest(0, 10)).getContent();
    }
    
   /* @GetMapping(value = "/run", produces = APPLICATION_JSON_UTF8_VALUE)
    public String get() {
        return isUsersCanMakeStakes() ? "enabled" : "disabled";
    }*/
}

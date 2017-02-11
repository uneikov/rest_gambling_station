package com.uran.rest_gambling_station.web;

import com.uran.rest_gambling_station.domain.Horse;
import com.uran.rest_gambling_station.dto.HorseDto;
import com.uran.rest_gambling_station.service.HorseService;
import com.uran.rest_gambling_station.util.horse.HorseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(value = "/horses")
public class HorseRestController {
    
    @Autowired
    private HorseService horseService;
    
    @GetMapping(produces = APPLICATION_JSON_UTF8_VALUE)
    public List<Horse> getHorses() {
        return this.horseService.findAll();
    }
    
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    public Horse getHorse(@PathVariable("id") final long id) {
        return this.horseService.findById(id);
    }
    
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") final int id) {
        this.horseService.delete(id);
    }
    
    @PostMapping(value = "/{id}")
    public void toggleReady(@PathVariable("id") final int id) {
        Horse horse = this.horseService.findById(id);
        horse.setReady(!horse.isReady());
        this.horseService.save(horse);
    }
    
    @PostMapping
    public void createOrUpdate(@Valid final HorseDto horseDto) {
        if (horseDto.isNew()) {
            this.horseService.save(HorseUtil.createNewFromTo(horseDto));
        } else {
            this.horseService.update(horseDto);
        }
    }
    
    @GetMapping(value = "/names", produces = APPLICATION_JSON_UTF8_VALUE)
    public List<String> getAllReadyForRaceHorsesNamesAsList() {
        return this.horseService.findByReadyTrue().stream()
                .map(Horse::getName)
                .collect(Collectors.toList());
    }
}

 /*@PostMapping(value = "/{id}")
    public void enable(@PathVariable("id") final int id) {
        Horse horse = this.horseService.findById(id);
        if (!horse.isReady()){
            horse.setReady(!horse.isReady());
            this.horseService.save(horse);
        }
    }*/
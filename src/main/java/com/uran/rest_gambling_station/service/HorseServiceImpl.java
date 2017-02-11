package com.uran.rest_gambling_station.service;

import com.uran.rest_gambling_station.domain.Horse;
import com.uran.rest_gambling_station.dto.HorseDto;
import com.uran.rest_gambling_station.repository.HorseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.uran.rest_gambling_station.util.horse.HorseUtil.updateFromTo;

@Component(value = "horseService")
public class HorseServiceImpl implements HorseService {
    
    @Autowired
    private HorseRepository repository;
    
    @Override
    public Page<Horse> findAll(final Pageable pageable) {
        return this.repository.findAll(pageable);
    }
    
    @Override
    public List<Horse> findAll() {
        return this.repository.findAll();
    }
    
    @Override
    public Horse findById(final long id) {
        return this.repository.findOne(id);
    }
    
    @Override
    public void delete(long id) {
        this.repository.delete(id);
    }
    
    @Override
    public Horse save(Horse horse) {
        return this.repository.save(horse);
    }
    
    @Override
    public Horse update(Horse horse) {
        return this.repository.save(horse);
    }
    
    @Override
    public Horse update(HorseDto horseDto) {
        Horse horse = updateFromTo(this.repository.findOne(horseDto.getId()), horseDto);
        return this.repository.save(horse);
    }
}

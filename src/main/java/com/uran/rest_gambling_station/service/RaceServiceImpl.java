package com.uran.rest_gambling_station.service;

import com.uran.rest_gambling_station.domain.Race;
import com.uran.rest_gambling_station.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("raceService")
public class RaceServiceImpl implements RaceService{
    
    @Autowired
    private RaceRepository repository;
    
    @Override
    public Page<Race> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }
    
    @Override
    public List<Race> findAll() {
        return this.repository.findAll();
    }
    
    @Override
    public Race findById(long id) {
        return this.repository.findOne(id);
    }
}

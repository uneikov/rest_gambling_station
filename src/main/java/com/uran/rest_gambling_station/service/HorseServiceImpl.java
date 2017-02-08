package com.uran.rest_gambling_station.service;

import com.uran.rest_gambling_station.domain.Horse;
import com.uran.rest_gambling_station.repository.HorseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component(value = "horseService")
public class HorseServiceImpl implements HorseService {
    @Autowired
    private HorseRepository repository;
    
    @Override
    public Page<Horse> findAll(final Pageable pageable) {
        return this.repository.findAll(pageable);
    }
    
    @Override
    public Horse findById(final long id) {
        return this.repository.findOne(id);
    }
}

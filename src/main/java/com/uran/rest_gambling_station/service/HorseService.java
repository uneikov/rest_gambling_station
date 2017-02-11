package com.uran.rest_gambling_station.service;

import com.uran.rest_gambling_station.domain.Horse;
import com.uran.rest_gambling_station.dto.HorseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HorseService {
    
    Page<Horse> findAll(Pageable pageable);
    List<Horse> findAll();
    Horse findById(long id);
    void delete(long id);
    Horse save(Horse horse);
    Horse update(Horse horse);
    Horse update(HorseDto horseDto);
}

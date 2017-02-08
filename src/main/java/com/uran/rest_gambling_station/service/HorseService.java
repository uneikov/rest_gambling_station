package com.uran.rest_gambling_station.service;

import com.uran.rest_gambling_station.domain.Horse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HorseService {
    
    Page<Horse> findAll(Pageable pageable);
    
    Horse findById(long id);
}

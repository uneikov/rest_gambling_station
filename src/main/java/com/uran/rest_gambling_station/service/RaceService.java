package com.uran.rest_gambling_station.service;

import com.uran.rest_gambling_station.domain.Race;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RaceService {
    Page<Race> findAll(Pageable pageable);
    List<Race> findAll();
    Race findById(long id);
}

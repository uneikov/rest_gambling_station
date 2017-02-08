package com.uran.rest_gambling_station.service;

import com.uran.rest_gambling_station.domain.Stake;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StakeService {
    
    Page<Stake> findAll(Pageable pageable);
    
    Stake findById(long id);
    
    Page<Stake> findAllByRaceId(long id, Pageable pageable);
    
    Page<Stake> findAllByUserId(long id, Pageable pageable);
    
    Stake addStake(Stake stake);
    
    void delete(long id);
    
}

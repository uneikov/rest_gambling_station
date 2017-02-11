package com.uran.rest_gambling_station.service;

import com.uran.rest_gambling_station.domain.Stake;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;

public interface StakeService {
    
    @Secured("ROLE_ADMIN")
    Page<Stake> findAll(Pageable pageable);
    
    @Secured("ROLE_ADMIN")
    Stake findById(long id);
    
    Page<Stake> findAllByRaceId(long id, Pageable pageable);
    
    Page<Stake> findAllByUserId(long id, Pageable pageable);
    
    Page<Stake> findAllByRaceIdUserId(final long raceId, final long userId,  final Pageable pageable);
        
    Stake addStake(Stake stake);
    
    void delete(long id);
    
}

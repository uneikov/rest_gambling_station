package com.uran.rest_gambling_station.repository;

import com.uran.rest_gambling_station.domain.Stake;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

//http://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html

public interface StakeRepository extends JpaRepository<Stake, Long> {
    
    Page<Stake> findByUserId(long id, Pageable pageable);
    
    Page<Stake> findByRaceId(long id, Pageable pageable);
    
    Page<Stake> findByRaceIdAndUserId(long raceId, long userId, Pageable pageable);
    
}

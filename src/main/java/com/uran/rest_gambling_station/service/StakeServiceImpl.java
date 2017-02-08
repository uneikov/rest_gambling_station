package com.uran.rest_gambling_station.service;

import com.uran.rest_gambling_station.domain.Stake;
import com.uran.rest_gambling_station.repository.StakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component(value = "stakeService")
public class StakeServiceImpl implements StakeService{
    
    @Autowired
    private StakeRepository repository;
    
    @Override
    public Page<Stake> findAll(Pageable pageable){
        return this.repository.findAll(pageable);
    }
    
    @Override
    public Stake findById(long id) {
        return this.repository.findOne(id);
    }
    
    @Override
    public Page<Stake> findAllByRaceId(long id, Pageable pageable) {
        return this.repository.findByRaceId(id, pageable);
    }
    
    @Override
    public Page<Stake> findAllByUserId(long id, Pageable pageable) {
        return this.repository.findByUserId(id, pageable);
    }
    
    @Override
    public Stake addStake(Stake stake) {
        return repository.save(stake);
    }
    
    @Override
    public void delete(long id) {
        repository.delete(id);
    }
    
}

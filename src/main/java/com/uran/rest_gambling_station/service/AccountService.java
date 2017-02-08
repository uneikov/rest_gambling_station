package com.uran.rest_gambling_station.service;

import com.uran.rest_gambling_station.domain.Account;

public interface AccountService {
    
    Account get(long userId);
    
    Account debitUserAccount(long userId, double value);
    
    Account creditUserAccount(long userId, double value);
    
    Account debitStationAccount(double value);
    
    Account creditStationAccount(double value);
    
    void transferToStation(long userId, double value);
    
    void transferToUser(long userId, double value);
}

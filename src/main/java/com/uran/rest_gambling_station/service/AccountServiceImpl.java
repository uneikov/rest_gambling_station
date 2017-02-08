package com.uran.rest_gambling_station.service;

import com.uran.rest_gambling_station.domain.Account;
import com.uran.rest_gambling_station.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component(value = "accountService")
@Transactional
public class AccountServiceImpl implements AccountService {
    
    @Autowired
    private AccountRepository repository;
    
    @Override
    @Transactional(readOnly = true)
    public Account get(long userId) {
        return this.repository.findOne(userId);
    }
    
    @Override
    public Account debitUserAccount(final long userId, final double value) {
       //if (value < 0.0) throw new NegativeValueException();
       final Account account = this.repository.findByUserId(userId);
       account.setBalance(account.getBalance() - value);
       return this.repository.save(account);
    }
    
    @Override
    public Account creditUserAccount(final long userId, final double value) {
        final Account account = this.repository.findByUserId(userId);
        account.setBalance(account.getBalance() + value);
        return this.repository.save(account);
    }
    
    @Override
    public Account debitStationAccount(final double value) {
        final Account account = this.repository.findByUserId(getStationId());
        account.setBalance(account.getBalance() - value);
        return this.repository.save(account);
    }
    
    @Override
    public Account creditStationAccount(final double value) {
        final Account account = this.repository.findByUserId(getStationId());
        account.setBalance(account.getBalance() + value);
        return this.repository.save(account);
    }
    
    @Override
    public void transferToUser(long userId, double value) {
        debitStationAccount(value);
        creditUserAccount(userId, value);
    }
    
    @Override
    public void transferToStation(final long userId, final double value) {
        debitUserAccount(userId, value);
        creditStationAccount(value);
    }
    
    private Long getStationId() {
        return this.repository.findByUserEmailIgnoringCase("station@gamblingstation.com").getUser().getId();
        /*Set<Role> roles = new HashSet<Role>();
        roles.add(Role.ROLE_STATION);
        return this.repository.findByUserRoles(roles).getUser().getId();*/
    }
}

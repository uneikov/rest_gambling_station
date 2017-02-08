package com.uran.rest_gambling_station.service;

import com.uran.rest_gambling_station.domain.Account;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class AccountServiceTest {
    
    @Autowired
    private AccountService service;
    
    @Test
    public void debitAccount() throws Exception {
        final Account account = this.service.debitUserAccount(1L, 5.0);
        Assert.assertEquals(account.getBalance(), 5.0, 0.001);
    }
    
    @Test
    public void creditAccount() throws Exception {
        final Account account = this.service.creditUserAccount(1L, 5.0);
        Assert.assertEquals(account.getBalance(), 15.0, 0.001);
    }
    
    @Test
    public void shouldTransferFromUserToStationAccount() {
        this.service.transferToStation(1L, 5);
        Account user = this.service.get(1L);
        Account station = this.service.get(4L);
        Assert.assertEquals(user.getBalance(), 5.0, 0.001);
        Assert.assertEquals(station.getBalance(), 105.0, 0.001);
    }
    
    @Test
    public void shouldTransferFromStationToUserAccount() {
        this.service.transferToUser(1L, 5);
        Account user = this.service.get(1L);
        Account station = this.service.get(4L);
        Assert.assertEquals(user.getBalance(), 15.0, 0.001);
        Assert.assertEquals(station.getBalance(), 95.0, 0.001);
    }
}
package com.uran.rest_gambling_station.service;

import com.uran.rest_gambling_station.domain.Account;
import com.uran.rest_gambling_station.repository.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.uran.rest_gambling_station.data.AccountTestData.ACC_USER_1;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class AccountServiceIntegrationTest {
    @Autowired
    private AccountRepository repository;
    
    @Test
    public void shouldReturnOneAccountById() {
        Account account = this.repository.findOne(1L);
        assertThat(account.equals(ACC_USER_1));
    }
    
    @Test
    public void shouldReturnAllAccounts() {
        List<Account> accounts = this.repository.findAll();
        assertThat(accounts.size()).isEqualTo(4);
        //Assert.assertEquals(accounts, ACCOUNTS);
    }
    
}

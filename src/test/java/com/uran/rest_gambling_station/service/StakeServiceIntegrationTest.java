package com.uran.rest_gambling_station.service;

import com.uran.rest_gambling_station.domain.Stake;
import com.uran.rest_gambling_station.repository.StakeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

import static com.uran.rest_gambling_station.data.StakeTestData.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
//@DataJpaTest
//@AutoConfigureTestDatabase(connection = H2)
public class StakeServiceIntegrationTest {
    @Autowired
    private StakeRepository repository;
    
    @Test
    public void shouldFindOneStake() {
        Stake stake = this.repository.findOne(1L);
        assertThat(stake.equals(STAKE_1));
    }
    
    @Test(expected = NullPointerException.class)
    public void shouldNotFindOneStake() {
        Stake stake = this.repository.findOne(10L);
        assertThat(stake.equals(STAKE_1));
    }
    
    @Test
    public void shouldDeleteOneStake() {
        this.repository.delete(1L);
        Page<Stake> page = this.repository.findAll(new PageRequest(0, 10));
        assertThat(page.getContent().size()).isEqualTo(4);
    }
    
    @Test
    public void shouldFindAllStakes() {
        Page<Stake> page = this.repository.findAll(new PageRequest(0, 10));
        assertThat(page.getContent().size()).isEqualTo(5);
    }
    
    @Test
    public void shouldFindFirstPageOfStakes() {
        Page<Stake> page = this.repository.findByUserId(1L, new PageRequest(0, 10));
        assertThat(page.getContent().size()).isEqualTo(3);
    }
    
    @Test
    public void shouldReturnStakeByRaceIdAndUserId() {
        Page<Stake> page = this.repository.findByRaceIdAndUserId(4L, 1L, new PageRequest(0, 10));
        assertThat(page.getContent().size()).isEqualTo(1);
    }
    
    @Test
    public void shouldSaveStake() {
        final Page<Stake> page0 = this.repository.findByRaceId(4L, new PageRequest(0, 10));
        this.repository.save(getCreated());
        final Page<Stake> page = this.repository.findByRaceId(4L, new PageRequest(0, 10));
        assertThat(page.getContent().get(0).equals(getCreated()));
        assertThat(page.getContent().size()).isEqualTo(3);
    }
    
    @Test
    public void shouldSaveStakesList() {
        this.repository.save(Arrays.asList(getCreated(), getCreatedMore()));
        final Page<Stake> page = this.repository.findByRaceId(4L, new PageRequest(0, 10));
        assertThat(page.getContent().get(0).equals(getCreated()));
        assertThat(page.getContent().get(1).equals(getCreatedMore()));
        assertThat(page.getContent().size()).isEqualTo(4);
    }
}

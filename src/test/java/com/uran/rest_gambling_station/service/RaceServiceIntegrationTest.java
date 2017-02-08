package com.uran.rest_gambling_station.service;

import com.uran.rest_gambling_station.domain.Race;
import com.uran.rest_gambling_station.repository.RaceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.uran.rest_gambling_station.data.RaceTestData.RACE_1;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RaceServiceIntegrationTest {
    @Autowired
    private RaceRepository repository;
    
    @Test
    public void shouldReturnRaceById() {
        Race race = this.repository.findOne(1L);
        assertThat(race.equals(RACE_1));
    }
    
    @Test
    public void shouldReturnAllRaces() {
        Page page = repository.findAll(new PageRequest(0, 10));
        assertThat(page.getTotalPages()).isEqualTo(1);
        assertThat(page.getTotalElements()).isEqualTo(4);
    }
}

package com.uran.rest_gambling_station.service;

import com.uran.rest_gambling_station.domain.Horse;
import com.uran.rest_gambling_station.repository.HorseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class HorseServiceIntegrationTest {
    @Autowired
    private HorseRepository repository;
    
    @Test
    public void shouldReturnFirstPageOfHorses() {
        Page<Horse> page = this.repository.findAll(new PageRequest(0, 10));
        assertThat(page.getContent().size()).isEqualTo(10);
        assertThat(page.getContent().get(0).getName()).contains("Black Ghost");
    }
    
    @Test
    public void shouldReturnOneHorseById() {
        Horse horse = this.repository.findOne(1L);
        assertThat(horse.getName()).isEqualTo("Black Ghost");
    }
}

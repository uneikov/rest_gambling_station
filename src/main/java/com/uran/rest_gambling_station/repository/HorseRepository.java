package com.uran.rest_gambling_station.repository;

import com.uran.rest_gambling_station.domain.Horse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorseRepository extends JpaRepository<Horse, Long> {
}

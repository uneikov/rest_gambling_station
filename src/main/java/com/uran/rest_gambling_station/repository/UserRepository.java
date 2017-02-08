package com.uran.rest_gambling_station.repository;

import com.uran.rest_gambling_station.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
    //@Query("select u from User u where u.email = ?1")
    User findByEmailIgnoringCase(String email);
}

package com.uran.rest_gambling_station.repository;

import com.uran.rest_gambling_station.domain.Account;
import com.uran.rest_gambling_station.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface AccountRepository extends JpaRepository<Account, Long> {
    
    Account findByUserId(long userId);
    Account findByUserEmailIgnoringCase(String email);
    Account findByUserRoles(Set<Role> roles);
}

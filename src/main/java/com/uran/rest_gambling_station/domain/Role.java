package com.uran.rest_gambling_station.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority{
    ROLE_USER,
    ROLE_ADMIN,
    ROLE_STATION;
    
    @Override
    public String getAuthority() {
        return name();
    }
}
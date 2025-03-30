package com.vivek.ridesharing.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN, RIDER, DRIVER;

    @Override
    public String getAuthority() {
        return "ROLE_" + name();
    }
}

package com.vivek.ridesharing.config;

import com.vivek.ridesharing.model.Role;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;


public class JwtUtilTest {

    private final JwtUtil jwtUtil = new JwtUtil();
    private static final Logger logger = LoggerFactory.getLogger(JwtUtilTest.class);

    @Test
    void testGenerateAndExtractToken() {
        String username = "kvivek3";
        Set<Role> roles = Set.of(Role.ADMIN);
        String token = jwtUtil.generateToken(username, roles);
        logger.info(token);
        assertNotNull(token);
        assertEquals(username, jwtUtil.extractUsername(token));
        //assertFalse(jwtUtil.isTokenExpired(token));
    }
    @Test
    void testValidateToken() {
        String username = "kvivek3";
        Set<Role> roles = Set.of(Role.ADMIN);
        String token = jwtUtil.generateToken(username, roles);
        UserDetails userDetails = new User(username, "1234",roles);
        logger.info(userDetails.toString());
        assertTrue(jwtUtil.validateToken(token, userDetails));
    }
}

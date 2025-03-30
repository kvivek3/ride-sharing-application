package com.vivek.ridesharing.controller;


import com.vivek.ridesharing.config.JwtUtil;
import com.vivek.ridesharing.dto.AuthRequest;
import com.vivek.ridesharing.dto.AuthResponse;
import com.vivek.ridesharing.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

@RestController
@RequestMapping("api")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    @Autowired
    private final UserDetailsService userDetailsService;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/authenticate")
    public AuthResponse authenticate(@RequestBody AuthRequest authRequest) {
        logger.info("Authentication request received for username: {} {}", authRequest.getUsername(), authRequest.getPassword());

        logger.info("Checking UserDetails in DB");
        UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        logger.info("User Details from DB : " + userDetails.toString());
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        //UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        return new AuthResponse(jwtUtil.generateToken(userDetails.getUsername(), (Set<Role>) userDetails.getAuthorities()));
    }

}

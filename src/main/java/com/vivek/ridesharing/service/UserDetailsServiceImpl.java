package com.vivek.ridesharing.service;

import com.vivek.ridesharing.model.Users;
import com.vivek.ridesharing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Reached Database for " + username);
        Users user = userRepository.findByUsername(username)
                .orElseThrow(() -> {

                    System.out.println("User Not Found: " + username);
                    return new UsernameNotFoundException("User Not Found: " + username);
                });

        System.out.println(user.getUsername());
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getRoles());
    }
}
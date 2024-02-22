package com.example.springweb.Service;

import com.example.springweb.Entity.CustomUserDetails;
import com.example.springweb.Entity.User;
import com.example.springweb.Repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private LoginRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByName(username);
        if (user == null) {
            System.out.println("register user first");
            throw new UsernameNotFoundException("user not found");
        }
        return new CustomUserDetails(user);
    }
}

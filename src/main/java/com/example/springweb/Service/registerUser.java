package com.example.springweb.Service;

import com.example.springweb.Entity.User;
import com.example.springweb.Repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class registerUser {
    @Autowired
    private LoginRepo repo;

    public void saveUserData(User user) {
        System.out.println(user.getUsername());
        User isUserPresent = repo.findByName(user.getUsername());
        System.out.println(isUserPresent);
        if (isUserPresent == null) {
            repo.save(user);
        }
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = repo.findByName(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//        return new User(user.getUsername(), user.getPassword());
//    }
}

package com.example.Accounts.service;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if ("javainuse".equals(username)) {
            return  new User("javainuse","$2a$12$sutulXgso0Z0t2gLFrX9EuLvvluZlWV.NogHjY8foHba2Abirl0uG",new ArrayList<>());
        }
        else {
            throw new UsernameNotFoundException("User not Found Exception"+username);
        }
    }
}
package com.example.Accounts.service;
import com.example.Accounts.repository.DAOUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class JwtUserDetailsService implements UserDetailsService {

    private DAOUserRepository daoUserRepository;
    private PasswordEncoder bcryptEncoder;

    JwtUserDetailsService(DAOUserRepository daoUserRepository,PasswordEncoder bcryptEncoder){
        this.daoUserRepository=daoUserRepository;
        this.bcryptEncoder=bcryptEncoder;
    }

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
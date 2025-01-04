package com.my_first_projecto.demo.infra;

import com.my_first_projecto.demo.domain.User;
import com.my_first_projecto.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

public class CostumUserDetailsService implements UserDetailsService {
@Autowired
    private UserRepository Repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.repository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails.User(User.getEmail(), user.getPassword(), new ArrayList<>());
    }
}

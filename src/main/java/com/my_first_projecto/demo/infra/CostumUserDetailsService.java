package com.my_first_projecto.demo.infra;

import com.my_first_projecto.demo.domain.User;
import com.my_first_projecto.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CostumUserDetailsService implements UserDetailsService {
@Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.repository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("User not found"))
    }
}

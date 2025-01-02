package com.my_first_projecto.demo.repositories;

import com.my_first_projecto.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    @Override
    Optional<User> findById(String email);
}

package com.example.zenrea_backend.repository;

import com.example.zenrea_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {

    @Query(value = "select * from users where username=?1", nativeQuery = true)
    Optional<User> getUserByUsername(String username);
}


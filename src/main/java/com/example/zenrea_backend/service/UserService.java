package com.example.zenrea_backend.service;

import com.example.zenrea_backend.dto.UserDto;
import com.example.zenrea_backend.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    String save(UserDto userDto);

    List<User> getAll();

    Optional<User> getById(Integer id);

    void deleteById(Integer id);
}

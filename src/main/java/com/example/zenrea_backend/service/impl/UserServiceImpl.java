package com.example.zenrea_backend.service.impl;

import com.example.zenrea_backend.config.PasswordEncoderUtil;
import com.example.zenrea_backend.dto.UserDto;
import com.example.zenrea_backend.entity.User;
import com.example.zenrea_backend.repository.UserRepo;
import com.example.zenrea_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    @Override
    public String save(UserDto userDto) {

        User user = new User();

        if(userDto.getId()!=null) {
            user=userRepo.findById((userDto.getId())).orElseThrow(() ->new NullPointerException("data not found"));
        }

        user.setEmail(userDto.getEmail());
        user.setFullName(userDto.getFullName());
        user.setUsername(userDto.getUsername());
        user.setPassword(PasswordEncoderUtil.getInstance().encode(userDto.getPassword()));

        userRepo.save(user);


        return "created";
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> getById(Integer id) {
        return userRepo.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        userRepo.deleteById(id);
    }


}

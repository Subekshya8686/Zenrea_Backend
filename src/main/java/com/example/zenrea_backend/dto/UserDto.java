package com.example.zenrea_backend.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Integer id;

    private String fullName;

    private String email;

    private String username;

    private String password;

//    private String confirmPassword;
}

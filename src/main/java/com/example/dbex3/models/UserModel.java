package com.example.dbex3.models;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class UserModel {
    @NotEmpty(message = "UserName can not be null")
    private String username;
    @NotEmpty(message = "password can not be null")

    private String password;
}

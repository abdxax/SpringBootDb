package com.example.dbex3.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Columns;

@Data
@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Name can be null")
    @Size(min = 4,message = "name Length more than 4")
    private String name;
    @NotEmpty(message = "username can be null")
    @Size(min = 4,message = "username Length more than 4")
    private String username;
    @NotEmpty(message = "Name can be null")
    private String password;
    @NotEmpty(message = "email can be null")
    @Email
    @Column(columnDefinition = "varchar(10) unique")
    private String email;
    @NotEmpty(message = "role can be null")
    @Pattern(regexp = "user|admin",message = "the role must be user or admin ")
    private String role;
    @NotNull(message = "age is not null")
    private int age;
}

package com.example.crudautenticado.Model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Getter
@Setter
@Entity(name = "Users")
public class UserModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;


    @NotBlank
    @Column(name = "email", unique = true,nullable = false)
    private String login;

    public UserModel() {
    }

    public UserModel(long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    @NotBlank
    @Column(nullable = false)
    private String password;

    public UserModel(String login, String password) {
        this.login = login;
        this.password = password;
    }
}

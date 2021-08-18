package com.example.crudautenticado.Repositories;

import com.example.crudautenticado.Model.UserModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepo extends CrudRepository<UserModel, Long> {
     Optional<UserModel> findByLogin(String login);

}

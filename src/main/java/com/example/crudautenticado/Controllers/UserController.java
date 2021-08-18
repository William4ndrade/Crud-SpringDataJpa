package com.example.crudautenticado.Controllers;

import com.example.crudautenticado.Model.UserModel;
import com.example.crudautenticado.Services.UserServices;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    private final UserServices UserServices;
    @Autowired
    public UserController(com.example.crudautenticado.Services.UserServices userServices) {
        UserServices = userServices;
    }

    @PostMapping("/new")
    public ResponseEntity<UserModel> CreateNewUser(@Valid @RequestBody UserModel user){
        return UserServices.CreateNewUser(user);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserModel> GetUserById(@PathVariable Long id){
        return UserServices.GetUserById(id);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Boolean> DeleteUserById(@PathVariable Long id){
        return UserServices.DeleteUserById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<UserModel> UpdateUserByUser(@RequestBody UserModel user){
        return UserServices.UpdateUser(user);
    }

}

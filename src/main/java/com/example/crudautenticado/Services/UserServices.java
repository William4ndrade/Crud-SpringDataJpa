package com.example.crudautenticado.Services;

import com.example.crudautenticado.Exceptions.UserNotFoundException;
import com.example.crudautenticado.Model.UserModel;
import com.example.crudautenticado.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
@Service
public class UserServices {

    private UserRepo userRepo;

    @Autowired
    public UserServices(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public ResponseEntity<UserModel> CreateNewUser(UserModel user){
       return ResponseEntity.ok(userRepo.save(user));
    }

    public ResponseEntity<UserModel> UpdateUser(UserModel user){
        if(userRepo.findById(user.getId()).isEmpty()){
            throw new UserNotFoundException(user.getId());
        }
        return ResponseEntity.ok(userRepo.save(user));
    }

    public ResponseEntity<UserModel> GetUserById(long id){
        Optional<UserModel> User =  userRepo.findById(id);
        if(User.isPresent()){
            return ResponseEntity.ok(User.get());
        }

        throw new UserNotFoundException(id);


    }


    public ResponseEntity<Boolean> DeleteUserById(long id){
        try {
            userRepo.deleteById(id);
            return ResponseEntity.ok(true);
        }catch (RuntimeException e){
            throw new UserNotFoundException(id);
        }


    }




}

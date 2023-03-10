package com.example.dbex3.controllers;

import com.example.dbex3.models.User;
import com.example.dbex3.models.UserModel;
import com.example.dbex3.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserConteroller {
    private final UserService userService;
    @GetMapping("/getAll")
    public List<User> getAll(){
        return userService.getAll();
    }
    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody @Valid User user){

        userService.addUser(user);
        return ResponseEntity.status(200).body("Added done");
    }
    @PutMapping("/updateUser/{id}")
    public ResponseEntity UpdateItem(@PathVariable Integer id,@RequestBody @Valid User user){

        Boolean res=userService.upateUser(id,user);
        if(!res){
            return ResponseEntity.status(400).body("Id IS ERROR");
        }
        return ResponseEntity.status(200).body("Update done");
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){

        Boolean res=userService.delete(id);
        if(!res){
            return ResponseEntity.status(400).body("Id IS ERROR");
        }
        return ResponseEntity.status(200).body("delete done");
    }
    @PostMapping("/getuserByUserNameAndPass")
    public ResponseEntity Login(@RequestBody @Valid UserModel userLogin){
        User user=userService.findByUsernameAndPassword(userLogin.getUsername(),userLogin.getPassword());
        return ResponseEntity.status(200).body(user);

    }
    @GetMapping("/getUserByEMAIL/{email}")
    public ResponseEntity getUserUserPass(@PathVariable  String email){
        User user=userService.findByEmail(email);
        return ResponseEntity.status(200).body(user);

    }

    @GetMapping("/getUsersByRole/{role}")
    public ResponseEntity getUsersRole(@PathVariable  String role){
        List<User> user=userService.findAllByRole(role);
        return ResponseEntity.status(200).body(user);

    }

    @GetMapping("/getUsersAge/{age}")
    public ResponseEntity getUsersAge(@PathVariable  int age){
        List<User> user=userService.findByAgeGreaterThanEqual(age);
        return ResponseEntity.status(200).body(user);

    }





}

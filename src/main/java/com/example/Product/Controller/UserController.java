package com.example.Product.Controller;


import com.example.Product.Model.User;
import com.example.Product.Service.UserService;
import com.example.Product.utility.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<ResponseStructure<User>> save(@RequestBody @Validated User user){
        return userService.saveUser(user);
    }
}

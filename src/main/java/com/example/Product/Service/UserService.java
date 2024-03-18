package com.example.Product.Service;

import com.example.Product.Model.User;
import com.example.Product.utility.ResponseStructure;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<ResponseStructure<User>> saveUser(User user);
}

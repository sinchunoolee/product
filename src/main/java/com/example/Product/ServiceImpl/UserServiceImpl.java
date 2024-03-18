package com.example.Product.ServiceImpl;

import com.example.Product.Model.User;
import com.example.Product.Repository.UserRepo;
import com.example.Product.Service.UserService;
import com.example.Product.utility.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;
    private ResponseStructure<User> structure;
    //	private ResponseStructure<List<User>> userStructureList;
    public UserServiceImpl(UserRepo repository) {
        this.userRepo = repository;
    }

    @Override
    public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
        return null;
    }
}



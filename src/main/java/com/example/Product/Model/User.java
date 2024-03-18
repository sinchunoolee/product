package com.example.Product.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.stereotype.Component;

@Component
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @NotNull
    private String userName;
    @Min(value = 6000000000l, message = "Invalid Contact Number!!")
    @Max(value = 9999999999l, message = "Invalid Contact Number!!")
    private long phoneNumber;
    @Email(regexp = "^[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z0-9]+$", message = "please enter valid email with @ and .")
    private String userEmail;
    //	@NotBlank(message = "Password is required")
//	@NotNull(message = "Password is required")
//	@Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Password must contain at least one letter, one number, one special character")
//	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$",message = "should follow password policy!!check it") //this regex doesn't work
    private String password;
    public User setUserId(int userId) {
        this.userId = userId;
        return this;
    }
    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }
    public User setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
    public User setUserEmail(String userEmail) {
        this.userEmail = userEmail;
        return this;
    }
    public User setPassword(String password) {
        this.password = password;
        return this;
    }
}

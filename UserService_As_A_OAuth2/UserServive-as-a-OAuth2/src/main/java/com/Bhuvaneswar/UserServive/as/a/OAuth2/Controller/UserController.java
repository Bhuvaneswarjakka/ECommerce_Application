package com.Bhuvaneswar.UserServive.as.a.OAuth2.Controller;

import com.Bhuvaneswar.UserServive.as.a.OAuth2.DTOs.LoginRequestDTO;
import com.Bhuvaneswar.UserServive.as.a.OAuth2.DTOs.SignUpRequestDTO;
import com.Bhuvaneswar.UserServive.as.a.OAuth2.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity userSignUp(@RequestBody SignUpRequestDTO signUpRequestDTO)
    {
        return null;
    }

    @PostMapping("/login")
    public ResponseEntity userLogin(@RequestBody LoginRequestDTO loginRequestDTO)
    {
        return null;
    }

    @GetMapping("/logout")
    public ResponseEntity userLogout()
    {
        return null;
    }

    @GetMapping("/validate")
    public ResponseEntity userValidate()
    {
        return null;
    }


}

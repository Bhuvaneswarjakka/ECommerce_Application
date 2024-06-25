package com.Bhuvaneswar.UserServive.as.a.OAuth2.Controller;

import com.Bhuvaneswar.UserServive.as.a.OAuth2.DTOs.LoginRequestDTO;
import com.Bhuvaneswar.UserServive.as.a.OAuth2.DTOs.SignUpRequestDTO;
import com.Bhuvaneswar.UserServive.as.a.OAuth2.DTOs.UserResponseDTO;
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
    public ResponseEntity<UserResponseDTO> userSignUp(@RequestBody SignUpRequestDTO signUpRequestDTO)
    {
        return ResponseEntity.ok(userService.userSignUp(signUpRequestDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> userLogin(@RequestBody LoginRequestDTO loginRequestDTO)
    {
        return ResponseEntity.ok(userService.userLogin(loginRequestDTO));
    }

    @GetMapping("/logout")
    public ResponseEntity<Boolean> userLogout(@RequestHeader("Authorisation") String authToken )
    {
        return ResponseEntity.ok(userService.userLogout(authToken));
    }

    @GetMapping("/validate")
    public ResponseEntity<Boolean> userValidate(@RequestHeader("Authorisation") String authToken)
    {
        return ResponseEntity.ok(userService.userValidate(authToken));
    }
}

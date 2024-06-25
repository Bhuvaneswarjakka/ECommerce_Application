package com.Bhuvaneswar.UserServive.as.a.OAuth2.Service;

import com.Bhuvaneswar.UserServive.as.a.OAuth2.DTOs.LoginRequestDTO;
import com.Bhuvaneswar.UserServive.as.a.OAuth2.DTOs.SignUpRequestDTO;
import com.Bhuvaneswar.UserServive.as.a.OAuth2.DTOs.UserResponseDTO;
import com.Bhuvaneswar.UserServive.as.a.OAuth2.Exceptions.InvalidCredentialsException;
import com.Bhuvaneswar.UserServive.as.a.OAuth2.Exceptions.RoleIsNotFoundExcetion;
import com.Bhuvaneswar.UserServive.as.a.OAuth2.Exceptions.TokenInvalidException;

public interface UserService
{
    UserResponseDTO userSignUp(SignUpRequestDTO signUpRequestDTO) throws RoleIsNotFoundExcetion;
    UserResponseDTO userLogin(LoginRequestDTO loginRequestDTO) throws InvalidCredentialsException;
    boolean userValidate(String token) throws TokenInvalidException;
    boolean userLogout(String token) throws TokenInvalidException;
}

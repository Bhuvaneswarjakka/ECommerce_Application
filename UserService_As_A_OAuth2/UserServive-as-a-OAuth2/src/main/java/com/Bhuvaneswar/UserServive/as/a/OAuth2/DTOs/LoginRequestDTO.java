package com.Bhuvaneswar.UserServive.as.a.OAuth2.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDTO
{
    private String emailId;
    private String password; // need to encrypt
}

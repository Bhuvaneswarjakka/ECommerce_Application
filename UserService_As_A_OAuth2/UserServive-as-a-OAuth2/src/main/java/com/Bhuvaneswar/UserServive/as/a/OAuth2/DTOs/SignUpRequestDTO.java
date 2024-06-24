package com.Bhuvaneswar.UserServive.as.a.OAuth2.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequestDTO
{
    private String nameOfUser;
    private String emailId;
    private String password; //need to encrypted
    private String phoneNumber;

}
